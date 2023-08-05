Data <- read.csv("CAHomes.csv")
head(Data)

X = Data[,-1]
Y = Data[,1]

library("nnet")
CA.nnet = nnet(X,Y,size=6,linout=T,skip=T,maxit=10000,decay=.05)

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

# Fit the model
nnetFit <- train(MEDV ~ .,
                 data = Data,
                 method = "nnet",
                 maxit = 1000,
                 linout=T,
                 skip=T,
                 tuneGrid = nnGrid,
                 trainControl = cvControl)


# View outcomes
nnetFit

