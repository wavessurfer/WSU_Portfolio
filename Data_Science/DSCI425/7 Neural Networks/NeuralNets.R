#Reading in Boston Housing Data

boston <- read.csv("Boston_Housing_Section7.csv")
View(boston)


#Get transformed data.frame
boston.trans = boston

boston.trans$CMEDV=log(boston$CMEDV)
boston.trans$CRIM =log(boston$CRIM)
boston.trans$LSTAT =log(boston$LSTAT)
boston.trans$ZN =log(boston$ZN+1)

#Names of all variables
names(boston.trans)


#Get and load nnet package
install.packages("nnet")
library(nnet)

#Doing this will allow results to be repeated
# -Search algorithm for weights has randomness to it.
set.seed(123456789)

#Fitting the nueral net
bos.nn = nnet(CMEDV~.,data=boston.trans,size=10,linout=T,skip=T,maxit=10000,decay=.001)

summary(bos.nn)

#Plot of actual vs fitted // on transformed scale
# Note: trendscat is part of Deppa's Regression Functions
#fitted() is part of nnet
trendscat(boston.trans$CMEDV,fitted(bos.nn),xlab="CMEDV", ylab="Fitted Values (CMEDV)")


## Neural Net Split-Sample CV
nnet.sscv <- function(x,y,fit,p=.667,B=100,size=3,decay=fit$decay,skip=T,
                      linout=T,maxit=10000){
  n = length(y)
  MSEP = rep(0,B)
  MAEP = rep(0,B)
  MAPEP = rep(0,B)
  ss = floor(n*p)
  for (i in 1:B){
    sam = sample(1:n,ss,replace=F)
    fit2 = nnet(x[sam,],y[sam],size=size,linout=linout,skip=skip,decay=decay,
                maxit=maxit,trace=F)
    ynew = predict(fit2,newdata=x[-sam,])
    MSEP[i]=mean((y[-sam]-ynew)^2)
    MAEP[i]=mean(abs(y[-sam]-ynew))
    MAPEP[i]=mean(abs(y[-sam]-ynew)/y[-sam])
  }
  RMSEP = sqrt(mean(MSEP))
  MAE = mean(MAEP)
  MAPE = mean(MAPEP)
  cat("RMSEP\n")
  cat("===============\n")
  cat(RMSEP,"\n\n")
  cat("MAE\n")
  cat("===============\n")
  cat(MAE,"\n\n")
  cat("MAPE\n")
  cat("===============\n")
  cat(MAPE,"\n\n")
  temp = data.frame(MSEP=MSEP,MAEP=MAEP,MAPEP=MAPEP)
  return(temp)
}

#Setting up the predictor and response
bos.x = boston.trans[,-1]
bos.y = boston.trans[,1]


#Using the nnet.sscv() function
results.nn10 = nnet.sscv(bos.x,bos.y,bos.nn,size=10)


##########################################################################################
## Neural Net Split-Sample CV
## Backtransformed version
nnet.sscv <- function(x,y,fit,p=.667,B=100,size=3,decay=fit$decay,skip=T,
                      linout=T,maxit=10000){
  n = length(y)
  MSEP = rep(0,B)
  MAEP = rep(0,B)
  MAPEP = rep(0,B)
  ss = floor(n*p)
  for (i in 1:B){
    sam = sample(1:n,ss,replace=F)
    fit2 = nnet(x[sam,],y[sam],size=size,linout=linout,skip=skip,
                decay=decay,maxit=maxit,trace=F)
    ynew = predict(fit2,newdata=x[-sam,])
    ystar = exp(y)
    ynew = exp(ynew)
    MSEP[i]=mean((ystar[-sam]-ynew)^2)
    MAEP[i]=mean(abs(ystar[-sam]-ynew))
    MAPEP[i]=mean(abs(ystar[-sam]-ynew)/ystar[-sam])
  }
  
  RMSEP = sqrt(mean(MSEP))
  MAE = mean(MAEP)
  MAPE = mean(MAPEP)
  cat("RMSEP\n")
  cat("===============\n")
  cat(RMSEP,"\n\n")
  cat("MAE\n")
  cat("===============\n")
  cat(MAE,"\n\n")
  cat("MAPE\n")
  cat("===============\n")
  cat(MAPE,"\n\n")
  temp = data.frame(MSEP=MSEP,MAEP=MAEP,MAPEP=MAPEP)
  return(temp)
}

#Using the nnet.sscv() function
results.nn3 = nnet.sscv(bos.x,bos.y,bos.nn,size=3)



