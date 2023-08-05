library(readr)
Concrete <- read_csv("Concrete.csv")
head(Concrete)

Concrete$Age = as.factor(Concrete$Age)


#Cross Validation
n = nrow(Concrete)
training = sample(1:n,size=floor(n*.666),replace=F)

train <- Concrete[training,]
test <- Concrete[-training,]

library(nnet)
library(caret)

#size = units for the hidden layer 
#linear output (necessary for regression problems using nnet) (linout = T)
#use a neural network with skip layer units (skip = T)
#set maximum number of iterations to a large number to “guarantee” convergence.
#decay = .0001 or .001 generally works “better” than the default = 0.

#Setting up k-fold with k=10
cvControl <- trainControl(method = "cv", number = 10)

#Creating a grid for neural net to search over
nnGrid <-  expand.grid(size = seq(3, 7, 2),
                       decay = c(0, 0.001, 0.01, 0.1))

# Set seed for reproducibility
set.seed(123456789)

# Fit the neural net
nnetFitHL <- train(train[,-1], #x
                   train$Strength, #y
                   method = "nnet",
                   maxit = 1000,
                   linout=T,
                   skip=T,
                   tuneGrid = nnGrid,
                   trainControl = cvControl,
                   #preProcess = "YeoJohnson"
)

# View outcomes
nnetFitHL

BestModelAllData = nnet(Strength ~ . ,data = Concrete, linout=T, skip=T,maxit=10000, size=3, decay=0.1)
names(BestModelAllData)

trendscat(Concrete$Strength,BestModelAllData$fitted.values,xlab="Actual", ylab="Pred", main = "Actual vs NeuNet")
abline(0,1,lwd=2,col="red") #slope=1, intercept= 0

# Monte-Carlo Split-Sample CV Function for Neural Network Regression Models
# Orginial version from Section 7 page 199.
# Modified to include R^Squared calculation on test/validation set

nnet.sscv<-function(x,y,fit,p=.667,B=100,size=5,decay=0.01,skip=T,linout=T,maxit=10000){
  n = length(y)
  RSquared = rep(0,B)
  MSEP = rep(0,B)
  MAEP = rep(0,B)
  MAPEP = rep(0,B)
  ss = floor(n*p)
  for (i in 1:B){
    sam = sample(1:n,ss,replace=F)
    fit2 = nnet(x[sam,],y[sam],size=size,linout=linout,skip=skip,decay=decay,
                maxit=maxit,trace=F)
    ynew = predict(fit2,newdata=x[-sam,])
    RSquared[i]=cor(y[-sam],ynew)^2
    MSEP[i]=mean((y[-sam]-ynew)^2)
    MAEP[i]=mean(abs(y[-sam]-ynew))
    MAPEP[i]=mean(abs(y[-sam]-ynew)/y[-sam])
  }
  MeanRSquared = mean(RSquared)
  RMSEP = sqrt(mean(MSEP))
  MAE = mean(MAEP)
  MAPE = mean(MAPEP)
  cat("Avg. R^2\n")
  cat("===============\n")
  cat(MeanRSquared,"\n\n")
  cat("RMSEP\n")
  cat("===============\n")
  cat(RMSEP,"\n\n")
  cat("MAE\n")
  cat("===============\n")
  cat(MAE,"\n\n")
  cat("MAPE\n")
  cat("===============\n")
  cat(MAPE,"\n\n")
  temp = data.frame(RSquared=RSquared,MSEP=MSEP,MAEP=MAEP,MAPEP=MAPEP)
  return(temp)
}

#Using the function for Concrete example, specification here include size=3 and decay = 0.1
FinalNN_CV <- nnet.sscv(x=Concrete[,2:9],y=Concrete$Strength, size=3, decay=0.1)

names(FinalNN_CV)
hist(FinalNN_CV$RSquared)


# Fit the model with Strength ^ 0.5
nnetFitTrans <- train(train[,-1], #x
                   (train$Strength^.5), #y
                   method = "nnet",
                   maxit = 1000,
                   linout=T,
                   skip=T,
                   tuneGrid = nnGrid,
                   trainControl = cvControl,
                   #preProcess = "YeoJohnson"
)

# View outcomes
nnetFitTrans

BestTransModelAllData = nnet( (Strength^.5) ~ . ,data = Concrete, linout=T, skip=T,maxit=10000, size=7, decay=0.1)
trendscat(Concrete$Strength,(BestTransModelAllData$fitted.values^2),xlab="Actual", ylab="Pred", main = "Actual vs NeuNet")
abline(0,1,lwd=2,col="red") #slope=1, intercept= 0


# Modified Monte-Carlo Split-Sample CV Function for Neural Network Regression Models
# to back transform the response

nnet.sscv.trans <-function(x,y,fit,p=.667,B=100,size=5,decay=0.01,skip=T,linout=T,maxit=10000){
  n = length(y)
  RSquared = rep(0,B)
  MSEP = rep(0,B)
  MAEP = rep(0,B)
  MAPEP = rep(0,B)
  ss = floor(n*p)
  for (i in 1:B){
    sam = sample(1:n,ss,replace=F)
    fit2 = nnet(x[sam,],y[sam],size=size,linout=linout,skip=skip,decay=decay,
                maxit=maxit,trace=F)
    ynew = (predict(fit2,newdata=x[-sam,])^2)
    RSquared[i]=cor(y[-sam],ynew)^2
    MSEP[i]=mean((y[-sam]-ynew)^2)
    MAEP[i]=mean(abs(y[-sam]-ynew))
    MAPEP[i]=mean(abs(y[-sam]-ynew)/y[-sam])
  }
  MeanRSquared = mean(RSquared)
  RMSEP = sqrt(mean(MSEP))
  MAE = mean(MAEP)
  MAPE = mean(MAPEP)
  cat("Avg. R^2\n")
  cat("===============\n")
  cat(MeanRSquared,"\n\n")
  cat("RMSEP\n")
  cat("===============\n")
  cat(RMSEP,"\n\n")
  cat("MAE\n")
  cat("===============\n")
  cat(MAE,"\n\n")
  cat("MAPE\n")
  cat("===============\n")
  cat(MAPE,"\n\n")
  temp = data.frame(RSquared=RSquared,MSEP=MSEP,MAEP=MAEP,MAPEP=MAPEP)
  return(temp)
}

FinalTransNN_CV <- nnet.sscv.trans(x=Concrete[,2:9],y=(Concrete$Strength^.5), size=7, decay=0.1)

####################### Redfin Claremont CA Home Prices #########################
data <- read_csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2022 SPRING/DSCI 425 Supervised Learning/7 Neural Networks/Task3/redfin_2022-05-16-22-26-24.csv")
head(data)

data_f <- na.omit(data[,c("PRICE","BEDS", "BATHS", 'SQUARE FEET', 'YEAR BUILT')])
View(data_f)

#Cross Validation
n = nrow(data_f)
training = sample(1:n,size=floor(n*.666),replace=F)

trainCA <- data_f[training,]
testCA <- data_f[-training,]

PredAcc = function(y,ypred){
  RMSEP = sqrt(mean((y-ypred)^2))
  MAE = mean(abs(y-ypred))
  MAPE = mean(abs(y-ypred)/y)*100
  RSq = cor(y,ypred)^2
  cat("RMSEP\n")
  cat("===============\n")
  cat(RMSEP,"\n\n")
  cat("MAE\n")
  cat("===============\n")
  cat(MAE,"\n\n")
  cat("MAPE\n")
  cat("===============\n")
  cat(MAPE,"\n\n")
  cat("Rsq\n")
  cat("===============\n")
  cat(RSq,"\n\n")
  return(data.frame(RMSEP=RMSEP,MAE=MAE,MAPE=MAPE,RSq=RSq))
}

model1 <- lm(PRICE~., data = trainCA)
pred1 <- predict(model1, newdata = testCA)
PredAcc(testCA$PRICE,pred1)

model2 <- lm(log(PRICE)~., data = trainCA)
pred2 <- exp(predict(model2, newdata = testCA))
PredAcc(testCA$PRICE,pred2)

#size = units for the hidden layer 
#linear output (necessary for regression problems using nnet) (linout = T)
#use a neural network with skip layer units (skip = T)
#set maximum number of iterations to a large number to “guarantee” convergence.
#decay = .0001 or .001 generally works “better” than the default = 0.

#Setting up k-fold with k=10
cvControl <- trainControl(method = "cv", number = 10)

#Creating a grid for neural net to search over
nnGrid <-  expand.grid(size = seq(3, 7, 2),
                       decay = c(0, 0.001, 0.01, 0.1))

# Set seed for reproducibility
set.seed(123456789)

# Fit the neural net
CAnnet <- train(trainCA[,-1], #x
                   trainCA$PRICE, #y
                   method = "nnet",
                   maxit = 1000,
                   linout=T,
                   skip=T,
                   tuneGrid = nnGrid,
                   trainControl = cvControl,
                   #preProcess = "YeoJohnson"
)

# View outcomes
CAnnet

model3_nnet = nnet(PRICE ~ . ,data = testCA, linout=T, skip=T,maxit=10000, size=3, decay=0.1)
PredAcc(testCA$PRICE,model3_nnet$fitted.values)



# Fit the trans neural net
CAnnet_log <- train(trainCA[,-1], #x
                log(trainCA$PRICE), #y
                method = "nnet",
                maxit = 1000,
                linout=T,
                skip=T,
                tuneGrid = nnGrid,
                trainControl = cvControl,
                #preProcess = "YeoJohnson"
)

# View outcomes
CAnnet_log

model4_nnet = nnet(log(PRICE) ~ . ,data = testCA, linout=T, skip=T,maxit=10000, size=7, decay=0)
PredAcc(testCA$PRICE,exp(model4_nnet$fitted.values))

#After assessing all models, #3 is the best, so we buil it on all the data

final = nnet(PRICE ~ . ,data = data_f, linout=T, skip=T,maxit=10000, size=3, decay=0.1)
PredAcc(data_f$PRICE,final$fitted.values)

trendscat(data_f$PRICE,final$fitted.values,xlab="Actual", ylab="Pred", main = "Actual vs NeuNet")
abline(0,1,lwd=2,col="red") #slope=1, intercept= 0
