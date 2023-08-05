library(readr)
Concrete <- read_csv("Concrete.csv")
head(Concrete)

Concrete$Age = as.factor(Concrete$Age)

#Cross Validation
n = nrow(Concrete)
training = sample(1:n,size=floor(n*.666),replace=F)

train <- Concrete[training,]
test <- Concrete[-training,]

head(train)
dim(train)

head(test)
dim(test)

#MLR
model = lm(Strength~.,data=train)
summary(model)

#standard plots for linear model
par(mfrow=c(2,2)) #Divides the screen into 4 plotting regions in 2 rows and 2 columns
plot(model)

#loading Regressions functions from DSCI425 folder and car package
load(file.choose())
install.packages("car")
library(car)

pairs.plus(Concrete)

#added variable plot:
#It shows the relationship between the response(bodyfat) vs a single X predictor normalizing for the rest predictos
avPlots(model)

#other plots
Resplot(model)
Diagplot3(model)
VIF(model)

#vif with no package
vif(model)

pred1 <- predict(model, newdata = train)

trendscat(train$Strength,pred1,xlab="Actual Price",ylab="Predicted Price", main = "Training Set")
abline(0,1,lwd=2,col="red") #slope=1, intercept= 0

model_test = lm(Strength~.,data=test)
summary(model_test)

pred2 <- predict(model_test, newdata = test)

trendscat(test$Strength,pred2,xlab="Actual Price",ylab="Predicted Price", main = "Test Set")
abline(0,1,lwd=2,col="red") #slope=1, intercept= 0

mPredAcc = function(y,ypred){
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

PredAcc(train$Strength,pred1)

PredAcc(test$Strength,pred2)

################## Reduced and Transformed Model ###############

Concrete2 <- Concrete

#Check Skewness
#-1 > s > 1 : high : Bad
#-0.5 > s > 0.5 : mod
# -0.5 < s < 0.5 : fairly symmetrical : good

pairs.plus(Concrete)
Statplot(Concrete$Age)

myBC = function(y) {
  require(car)
  BCtran(y)
  results = powerTransform(y)
  summary(results)
}

#blastfurn: skew = .8 
summary(Concrete$BlastFurn) 
myBC(Concrete$BlastFurn+1) #add + 1 since it has 0s. Use YJPower instead of bcPower. Check above with (summary(Data$X))
Concrete2$BlastFurn <- yjPower(Concrete$BlastFurn,0.0166)

#Superplast: skew = .905
summary(Concrete$Superplast) 
myBC(Concrete$Superplast+1) #add + 1 since it has 0s. Use YJPower instead of bcPower. Check above with (summary(Data$X))
Concrete2$Superplast <- yjPower(Concrete$Superplast,0.2642)

invResPlot(model_test)

#plot above shows curvature which suggest transformation
Concrete2$Strength <- log(Concrete$Strength)

trans.model <- lm(Strength~.,data=Concrete2[training,])
summary(trans.model)

trans.mixed = step(trans.model)
summary(trans.mixed)

invResPlot(trans.mixed)

AVPs(trans.mixed)
ceresPlots(trans.mixed)

#poly.model <- lm(Strength ~ poly(Cement,2) + poly(BlastFurn,2) + 
#             poly(FlyAsh, 2) + poly(Water,2) + poly(Superplast,2) +
#             poly(FineAge,2) + Age, data = Concrete2)

poly.model <- lm(Strength ~ poly(Cement,2) + poly(BlastFurn,2) + 
                poly(FlyAsh, 2) + Water + I(Superplast^2) +
                I(FineAge^2) + Age, data = Concrete2[training,])

summary(poly.model)
poly.model.reduced <- step(poly.model)
summary(poly.model.reduced)

pred3 <- exp(predict(poly.model.reduced, newdata = Concrete2[-training,]))

PredAcc(test$Strength,pred3)
trendscat(test$Strength,pred3,xlab="Actual Price",ylab="Predicted Price", main = "Transformed Model in Test Set")
abline(0,1,lwd=2,col="red") #slope=1, intercept= 0

########## MARS #########
install.packages("earth")
library(earth)

#1 degree (no interaction)
mars1 = earth(Strength~.,degree=1,ncross=3,nfold=10,data=train, keepxy=T)
summary(mars1)
plot.earth.models(mars1$cv.list,which=1)
plot(mars1)
pred4 <- predict(mars1, newdata = test)
PredAcc(test$Strength,pred4)

mars1trans = earth(Strength~.,degree=1,ncross=3,nfold=10,data=Concrete2[-training,], keepxy=T)
summary(mars1trans)
plot.earth.models(mars1trans$cv.list,which=1)
plot(mars1trans)
pred5 <- exp(predict(mars1trans, newdata = Concrete2[-training,]))
PredAcc(test$Strength,pred5)

#Mars1trans is better
trendscat(test$Strength,pred5,xlab="Actual Price",ylab="Predicted Price", main = "MARS Transformed Model in Test Set")
abline(0,1,lwd=2,col="red") #slope=1, intercept= 0


#2 degrees (w interaction)
mars2 = earth(Strength~.,degree=2,ncross=3,nfold=10,data=train, keepxy=T)
summary(mars2)
plot.earth.models(mars2$cv.list,which=1)
plot(mars2)
pred6 <- predict(mars2, newdata = test)
PredAcc(test$Strength,pred6)


mars2trans = earth(Strength~.,degree=2,ncross=3,nfold=10,data=Concrete2[training,], keepxy=T)
summary(mars2trans)
plot.earth.models(mars2trans$cv.list,which=1)
plot(mars2trans)
pred7 <- exp(predict(mars2trans, newdata = Concrete2[-training,]))
PredAcc(test$Strength,pred7)

#Mars2trans is better
trendscat(test$Strength,pred7,xlab="Actual Price",ylab="Predicted Price", main = "MARS Transformed Model Degree 2 in Test Set")
abline(0,1,lwd=2,col="red") #slope=1, intercept= 0


#Measuring Variable Importance
evimp(mars2trans,trim=FALSE)
