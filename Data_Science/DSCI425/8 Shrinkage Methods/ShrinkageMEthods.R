#########################################################################
#  Section 8.1
#########################################################################


#########################################################################
# Reading the Bodyfat data set
BodyFat <- read.csv("BodyFat.csv")
View(BodyFat)

#Get all predictors and scale them
BodyFat.X <- BodyFat[,2:14]
BodyFat.Xscaled <- scale(BodyFat.X)
BodyFat.Y <- BodyFat[,1]

#Put scaled predictors and response together into a single data.frame
BodyFat.Model <- data.frame(BodyFat.Y,BodyFat.Xscaled) 
View(BodyFat.Model)

#######################################################################
#Fitting Ordinary Least Squares (OLS) Model with scaled predictors
BodyFat.LM <- lm(BodyFat.Y ~ . , data=BodyFat.Model)

#getting summary of the OLS model
summary(BodyFat.LM)

#Notice intercept term in model is same as mean of response
mean(BodyFat.Y)


######################################################################
# Ridge regression with lm.ridge() function in MASS package
install.packages("MASS")
library(MASS)

#Fit Ridge regression model with lambda = {0, 0.10, 0.20, ..., 99.8, 99.9, 100}
BodyFat.Ridge.MASS <- lm.ridge(BodyFat.Y ~ . ,data=BodyFat.Model, lambda=seq(0,100,0.1) )
select(BodyFat.Ridge.MASS)


######################################################################
# Ridge regression using the ridge() function in genridge
install.packages("genridge")
library(genridge)

#Using ridge() to fit the model - notice, Y and X's must be provided, not the standard formula, i.e. not y ~ .
BodyFat.Ridge.genridge.0to100 <- ridge(BodyFat.Y, BodyFat.Xscaled, lambda=seq(0,100,1) )

#Looking at amount of shrinkage for each variable
traceplot(BodyFat.Ridge.genridge.0to100)

# Zooming in on the optimal amount of shrinkage, max value of lambda is 4 here
BodyFat.Ridge.genridge.0to4 <- ridge(BodyFat.Y, BodyFat.Xscaled, lambda=seq(0,4,0.01) )

#Again, Looking at amount of shrinkage    
traceplot(BodyFat.Ridge.genridge.0to4)                           

# Redo for lambda = 0 to 4 by 1, for pairs plot
BodyFat.Ridge.genridge.0to4by1 <- ridge(BodyFat.Y, BodyFat.Xscaled, lambda=seq(0,4,1) )

#Creating a pairs plot to see how pairwise relationships are effected
#Each dot is for each value of lambda = 5 = 0,1,2,3,4
#The number on to upper left is the original value and the lower right is after shrinking
pairs(BodyFat.Ridge.genridge.0to4by1)

######################################################################
# Some 3D plotting for the change in parameter estimates
install.packages("rgl")
library(rgl)

#Looking at age, weight, and height
plot3d(coef(BodyFat.Ridge.genridge.0to4by1), variables=c(1,2,3) )

#Looking at weight, height, and abdomen
plot3d(coef(BodyFat.Ridge.genridge.0to4by1), variables=c(2,3,6) )


######################################################################
#Investigating the optimal settings for the shrinkage estimates

#Identify the best lambda, i.e. shrinkage estimate
select(BodyFat.Ridge.MASS)

BodyFat.Ridge.MASS.Best.HKB = lm.ridge(BodyFat.Y ~ . ,data=BodyFat.Model, lambda=c(1.66) )
BodyFat.Ridge.MASS.Best.LW = lm.ridge(BodyFat.Y ~ . ,data=BodyFat.Model, lambda=c(3.91) )
BodyFat.Ridge.MASS.Best.GCV = lm.ridge(BodyFat.Y ~ . ,data=BodyFat.Model, lambda=c(1.1) )
BodyFat.OLS = lm.ridge(BodyFat.Y ~ . ,data=BodyFat.Model, lambda=c(0) )


compare <- data.frame(coef(BodyFat.OLS),coef(BodyFat.Ridge.MASS.Best.HKB), coef(BodyFat.Ridge.MASS.Best.LW), coef(BodyFat.Ridge.MASS.Best.GCV) )                                   
compare

#####################################################################
#Function to get fitted values for ridge regression

RidgeFitted = function(fit,xmat) {
  p = length(coef(fit))
  fitted = coef(fit)[1] + xmat%*%coef(fit)[2:p]
  fitted
}

#Getting the predicted
Predicted.HKB <- RidgeFitted(fit=BodyFat.Ridge.MASS.Best.HKB, xmat=BodyFat.Xscaled)

#Plot actual vs fitted
plot(BodyFat.Y, Predicted.HKB, xlab="Actual BodyFat", ylab="Fitted from Optimal with HKB")
#Add y=x line to the plot
abline(0,1)

#Getting the residuals from the optimal fit with HKB
Residuals.HKB <- BodyFat.Y - Predicted.HKB

#Plotting residuals vs fitted
plot(Predicted.HKB, Residuals.HKB, xlab="Predicted Values", ylab="Residuals")
#Add y=0 line to the plot
abline(h=0)

#########################################################################
#########################################################################
#
#  SECTION 8.2
#
##########################################################################
#########################################################################

install.packages("glmnet")
library(glmnet)

#Get a model matrix for the scaled predictors
Xmatrix = model.matrix(BodyFat.Y ~ . ,data=BodyFat.Model)[,-1]

#Create a wide sequence of values for lamda
lambda_grid = 10^seq(10,-2,length=100)

#Set up a split-sample cross-validation, with 2/3 train and 1/3 test
n = nrow(BodyFat.Model)
p = .667

set.seed(9876543)
train = sample( n , floor(n*p) )


#Fit the Lasso regression model usin glmnet()
# Requires
# X matrix = model matrix that contains scaled predictors
# Y = response
# alpha = 1 for Lasso regression, i.e. L1 norm or absolute value
BodyFat.LassoModel = glmnet(Xmatrix[train,], BodyFat.Y[train], alpha=1, lambda=lambda_grid)

#Plot the shrinkage against value of lambda
plot(BodyFat.LassoModel,xvar="lambda")

######################################################################
# Use cross-validation to determine obtain optimal lambda based on 
#  the training data

set.seed(1234567)
CV.BodyFat.LassoModel = cv.glmnet(Xmatrix[train,], BodyFat.Y[train], alpha=1 )

#Look at effect of lambda on MSE
plot(CV.BodyFat.LassoModel)

#Get the best lambda for the least complex model
#This value returned here has been back-transformed
BestLambda.LassoModel = CV.BodyFat.LassoModel$lambda.min
BestLambda.LassoModel


#Fitting Lasso model using BestLambda
BodyFat.LassoModel.Final = glmnet(Xmatrix[train,], BodyFat.Y[train] ,alpha=1, lambda=BestLambda.LassoModel)
#Making predictions for the test data
LassoModel.Predicted = predict(BodyFat.LassoModel.Final, newx=Xmatrix[-train,])
#Compute MSEP for Lasso model using BestLambda
MSEP.Lasso = mean((BodyFat.Y[-train] - LassoModel.Predicted)^2)
MSEP.Lasso

##################################################################################
# Repeat cv cross-validation with training data to fit a Ridge Regression model
# alpha parameter set to 0 for Ridge regression

set.seed(543219876)
CV.BodyFat.RidgeModel = cv.glmnet(Xmatrix[train,], BodyFat.Y[train], alpha=0 )

#Look at effect of lambda on MSE
plot(CV.BodyFat.LassoModel)

#Get the best lambda for the least complex model
#This corresponds to lambda for the dotted line on the right
#This value has already been back-transformed
BestLambda.RidgeModel = CV.BodyFat.RidgeModel$lambda.min
BestLambda.RidgeModel


#Fitting Lasso model using BestLambda
BodyFat.RidgeModel.Final = glmnet(Xmatrix[train,], BodyFat.Y[train] ,alpha=0, lambda=BestLambda.RidgeModel)
#Making predictions for the test data
RidgeModel.Predicted = predict(BodyFat.RidgeModel.Final, newx=Xmatrix[-train,])
#Compute MSEP for Lasso model using BestLambda
MSEP.Ridge= mean((BodyFat.Y[-train] - RidgeModel.Predicted)^2)
MSEP.Ridge

#########################################################################
#########################################################################
#
#  SECTION 8.3
#
##########################################################################
#########################################################################

#########################################################################
# Split-Sample Monte Carlo Cross-Validation for ElasticNet models

glmnet.ssmc = function(X,y,p=.667,M=100,alpha=0.5,lambda=1) {
  RMSEP = rep(0,M)
  MAEP = rep(0,M)
  MAPEP = rep(0,M)
  n = nrow(X)
  for (i in 1:M) {
    ss = floor(n*p)
    sam = sample(1:n,ss,replace=F)
    fit = glmnet(X[sam,],y[sam],lambda=lambda,alpha=alpha)
    ypred = predict(fit,newx=X[-sam,])
    RMSEP[i] = sqrt(mean((y[-sam]-ypred)^2))
    MAEP[i] = mean(abs(y[-sam]-ypred))
    yp = ypred[y[-sam]!=0]
    ya = y[-sam][y[-sam]!=0]
    MAPEP[i]=mean(abs(yp-ya)/ya)
  }
  cat("RMSEP =",mean(RMSEP),"  MAEP=",mean(MAEP),"  MAPEP=",mean(MAPEP))
  cv = return(data.frame(RMSEP=RMSEP,MAEP=MAEP,MAPEP=MAPEP)) 
}

#Using cv.glmnet to get best lambda for Elastic Net model
CV.BodyFat.EN = cv.glmnet(Xmatrix, BodyFat.Y, alpha=0.5)
plot(CV.BodyFat.EN)
BestLambda.EN = CV.BodyFat.EN$lambda.min
BestLambda.EN

#Next, use Monte-Carlo split-sample cross-validation using best lambda for Elastic Net model
MCCV.EN = glmnet.ssmc(Xmatrix, BodyFat.Y, M=1000, alpha=0.5, lambda=BestLambda.EN)


#################################
# Seat Position Example

SeatPosition <- read.csv("C:/Teaching/DSCI425/Section8/SeatPosition.csv")
View(SeatPosition)

#Get all predictors - columns 2 through 9, rowid is 1st column and response (hipcenter) in last colmn
SeatPosition.X <- SeatPosition[,2:9]
SeatPosition.Xscaled <- scale(SeatPosition.X)
SeatPosition.Y <- SeatPosition[,10]


#Using cv.glmnet to get best lambda for Elastic Net model
CV.SeatPosition.EN = cv.glmnet(SeatPosition.Xscaled, SeatPosition.Y, alpha=0.5)
plot(CV.SeatPosition.EN)
BestLambda.EN = CV.SeatPosition.EN$lambda.min
BestLambda.EN

#Next, use Monte-Carlo split-sample cross-validation using best lambda for Elastic Net model
MCCV.EN = glmnet.ssmc(SeatPosition.Xscaled, SeatPosition.Y, M=1000, alpha=0.5, lambda=BestLambda.EN)



#################################
# Permeability Example

Permeability  <- read.csv("C:/Teaching/DSCI425/Section8/PermeabilityOriginal.csv")
View(Permeability)

hist(Permeability$permeability)

#Create a new data.frame with the log of permeability
Permeability.Log = Permeability
Permeability.Log$permeability = log(Permeability.Log$permeability)
View(Permeability.Log)

X = model.matrix(permeability~.,data=Permeability.Log)[,-1]
y = Permeability.Log$permeability
perm.ridge = glmnet(X,y,alpha=0)
plot(perm.ridge,xvar="lambda")

#########################################################################
# Split-Sample Monte Carlo Cross-Validation for ElasticNet models

MCCV.EN.Log = function(X,y,p=.667,M=100,alpha=0.50,lambda=1) {
  RMSEP = rep(0,M)
  MAEP = rep(0,M)
  MAPEP = rep(0,M)
  n = nrow(X)
  for (i in 1:M) {
    ss = floor(n*p)
    sam = sample(1:n,ss,replace=F)
    fit = glmnet(X[sam,],y[sam],lambda=lambda,alpha=alpha)
    ypred = predict(fit,newx=X[-sam,])
    ya = exp(y[-sam])
    ypred = exp(ypred)
    RMSEP[i] = sqrt(mean((ya-ypred)^2))
    MAEP[i] = mean(abs(ya-ypred))
    MAPEP[i]=mean(abs(ypred-ya)/ya)
  }
  cat("RMSEP =",mean(RMSEP),"  MAEP=",mean(MAEP),"  MAPEP=",mean(MAPEP))
  cv = return(data.frame(RMSEP=RMSEP,MAEP=MAEP,MAPEP=MAPEP))
  
}

#Using cv.glmnet to get best lambda for Elastic Net model
CV.Permeability.EN = cv.glmnet(X, y, alpha=0.5)
plot(CV.Permeability.EN)
BestLambda.EN = CV.Permeability.EN$lambda.min
BestLambda.EN

#Next, use Monte-Carlo split-sample cross-validation using best lambda for Elastic Net model
MCCV.EN = MCCV.EN.Log(X, y, M=1000, alpha=0.5, lambda=BestLambda.EN)

#Next, use Monte-Carlo split-sample cross-validation using best lambda for Ridge model
MCCV.EN = MCCV.EN.Log(X, y, M=1000, alpha=0, lambda=BestLambda.EN)

#Next, use Monte-Carlo split-sample cross-validation using best lambda for Lasso model
MCCV.EN = MCCV.EN.Log(X, y, M=1000, alpha=1, lambda=BestLambda.EN)

