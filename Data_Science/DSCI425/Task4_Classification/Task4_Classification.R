library(readr)
Genre_Train <- read_csv("Genre_Train.csv")
Genre_Validate <- read_csv("Genre_Validate.csv")
str(Genre_Validate)
str(Genre_Train)

Genre_Train$GENRE = as.factor(Genre_Train$GENRE)

n = nrow(Genre_Train)
training = sample(1:n,size=floor(n*.75),replace=F)

train <- Genre_Train[training,]
test <- Genre_Train[-training,]

######## CLASSIFICATION TREE ###############33
# Fit the classification tree with CARET to find optimal cp
library(caret)
# Set seed for reproducibility
set.seed(123456789)

trainx <- train[,-c(192)]
ctCaret <- train(trainx, #x
                 train$GENRE, #y
                 method = "rpart",
                 tuneGrid = expand.grid(cp = c(0.0001, 0.001, 0.01, 0.1, 1)),
)

ctCaret #cp = 0.01


# Fit the classification tree with RPART
library(rpart)
library(partykit)

#Cross Validation Class Tree Function
crpart.sscv = function(fit,y,data,B=25,p=.333) {
  n = length(y)
  cv <- rep(0,B)
  for (i in 1:B) {
    ss <- floor(n*p)
    sam <- sample(1:n,ss)
    temp <- data[-sam,]
    fit2 <- rpart(formula(fit),data=temp,parms=fit$parms,control=fit$control)
    ynew <- predict(fit2,newdata=data[sam,],type="class")
    tab <- table(y[sam],ynew)
    mc <- ss - sum(diag(tab))
    cv[i] <- mc/ss
  }
  cv
}


#Missclassification Rate Function
misclass.rpart = function (tree) 
{
  temp <- table(predict(tree, type = "class"), tree$y)
  cat("Table of Misclassification\n")
  cat("(row = predicted, col = actual)\n")
  print(temp)
  cat("\n\n")
  numcor <- sum(diag(temp))
  numinc <- length(tree$y) - numcor
  mcr <- numinc/length(tree$y)
  cat(paste("Misclassification Rate = ", format(mcr,digits = 3)))
  cat("\n")
}


ct1 <-rpart(GENRE~.,data = train,
            control = rpart.control(minsplit = 20, minbucket = 4, cp = 0.01)
)

plot(as.party(ct1))
summary(ct1)
misclass.rpart(ct1)

######## RANDOM FOREST ##############
install.packages("randomForest")
library(randomForest)

#Generic Function for Calculating Misclassification Rate
misclass = function(fit,y) {
  temp <- table(fit,y)
  cat("Table of Misclassification\n")
  cat("(row = predicted, col = actual)\n")
  print(temp)
  cat("\n\n")
  numcor <- sum(diag(temp))
  numinc <- length(y) - numcor
  mcr <- numinc/length(y)
  cat(paste("Misclassification Rate = ",format(mcr,digits=3)))
  cat("\n")
}

#Building the forest
#Number of trees: ntree
# size of the forest. size of how many predictors are getting averaged

#No. of variables tried at each split: mtry
# number of predictors used in each split.
# Be conscious of the amount of predictors in your actual data set.
# Less predictors cross validated better

#Best tuning parameters: ntree = 500, mtry = 13 (default values)
rf1 <- randomForest(GENRE~.,data=train, importance=T)
rf1

#Missclassification rate
misclass(predict(rf1,newdata = test),test$GENRE)

#Variable Importance
View(rf1$importance)
colnames(rf1$importance)
sort(rf1$importance[,8], decreasing = TRUE)


#Function for bar graph variable importance
rfimp.class = function(rffit,measure=1,horiz=T) {
  barplot(sort(rffit$importance[,measure]),horiz=horiz,xlab="Importance Measure",main="Variable Importance")
}

#Output
rfimp.class(rf1, measure = 3)

#Writing Predictions of Validate Set on CSV file
submission = data.frame(ID=Genre_Validate$id, PredictedGENRE= predict(rf1, newdata = Genre_Validate))
head(submission)

write.csv(submission,file="JoseOrtegaGenrePredictions.csv")

