library(readr)
Ozone <- read_csv("Ozone.csv")
View(Ozone)

load(file.choose())

#Check and attempt to get a normal distribution
Statplot(Ozone$upoz)
Statplot((Ozone$upoz^0.33))
Statplot(Ozone$upoz^0.2) #Boxcox suggestion
Statplot(log(Ozone$upoz)) #too agressive

Ozone2 <- data.frame(tupoz = Ozone$upoz^0.333, Ozone[,-1])
View(Ozone2)

install.packages("randomForest")
library(randomForest)
###########################################################
#My first randomForest

ozone.rf <- randomForest(tupoz~.,data=Ozone2, importance=T)
ozone.rf
#Number of trees: ntree
# size of the forest. size of how many predictos are getting averaged

#No. of variables tried at each split: mtry
# number of predictors used in each split.
# Be conscious of the amount of predictors in your actual dataset.
# Less predictors crossvalidated better

names(ozone.rf)
ozone.rf$importance

#Function for bar graph variable importance
rfimp = function(rffit) {barplot(sort(rffit$importance[,1]),horiz=T,
                                 xlab="Mean Decreasing in Accuracy",main="Variable Importance")
}

rfimp(ozone.rf)
