library(readxl)
data <- read_excel("ENB2012_data.xlsx")
names(data)

#Ys: Responses
HL <- data[,1]
CL <- data [,2]
#Variables

x <- data[,-c(1,2)]
str(x)

#Load Regression functions for other graphs
load(file.choose())

pairs.plus(data)
Statplot(data$`Heating Load`)
Statplot(data$`Cooling Load`)
Statplot(data$`Relative Compactness`)
Statplot(data$`Surface Area`)
Statplot(data$`Wall Area`)
Statplot(data$`Roof Area`)
Statplot(data$`Overall Height`)
Statplot(data$Orientation)
Statplot(data$`Glazing Area`)
Statplot(data$`Glazing Area Distribution`)


library(nnet)
library(caret)

#size = units for the hidden layer 
#linear output (necessary for regression problems using nnet) (linout = T)
#use a neural network with skip layer units (skip = T)
#set maximum number of iterations to a large number to “guarantee” convergence.
#decay = .0001 or .001 generally works “better” than the default = 0.

#CrossValidation
install.packages("caret")
library(caret)

#Setting up k-fold with k=10
cvControl <- trainControl(method = "cv", number = 10)

#Creating a grid for neural net to search over
nnGrid <-  expand.grid(size = seq(3, 7, 2),
                       decay = c(0.01, 0.05))

# Set seed for reproducibility
set.seed(123456789)

# Fit the model for Heating Load
nnetFitHL <- train(`Heating Load`~ .,
                 data = data[,-2],
                 method = "nnet",
                 maxit = 500,
                 linout=T,
                 skip=T,
                 tuneGrid = nnGrid,
                 trainControl = cvControl,
                 )

# View outcomes
nnetFitHL

trendscat(data$`Heating Load`,nnetFitHL$finalModel$fitted.values,xlab="Actual", ylab="Pred", main = "Actual vs NeuNet")

# Fit the model for Cooling Load
nnetFitCL <- train(`Cooling Load`~ .,
                 data = data[,-1],
                 method = "nnet",
                 maxit = 500,
                 linout=T,
                 skip=T,
                 tuneGrid = nnGrid,
                 trainControl = cvControl,
)

                 
# View outcomes
nnetFitCL
trendscat(data$`Heating Load`,nnetFitCL$finalModel$fitted.values,xlab="Actual", ylab="Pred", main = "Actual vs NeuNet")




###############################Classification #########
library(readr)
winequality <- read_csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2022 SPRING/DSCI 425 Supervised Learning/Final Project/winequality.csv")
str(winequality)
winequality$Class = as.factor(winequality$Class)
names(winequality)

library(rpart)
install.packages("partykit")
library(partykit)

ct1 <-rpart(Class~.,data = winequality)
ct1
ktree.party = as.party(ct1)
ktree.party
plot(ktree.party)

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


misclass.rpart(ct1)

