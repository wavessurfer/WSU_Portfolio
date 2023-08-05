library(readr)
EarthImpact <- read.csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2021 FALL/DSCI 415 Unsupervised Learning/Task1/EarthImpact.csv", stringsAsFactor=TRUE, fileEncoding="UTF-8-BOM")
View(EarthImpact)
names(EarthImpact)

#Step1: Only have the relevant columns
library(cluster)
Craters <- EarthImpact[,c(6:10)]
View(Craters)

#Step2: Daisy refracts numerical and categorical values  into the same scale
#Gower combines Eucludian (numerical) and jiccard (catgorical)
Craters.Dist <- daisy(Craters, metric = c("gower"), type = list(asymm=3:4))
summary(Craters.Dist)

library(MASS)
Impact.iso = isoMDS(Craters.Dist, k=2)

#Point used to plot the vizz
Impact.iso$points

#Basic Plot
plot(Impact.iso$points, type="n")
text(Impact.iso$points, labels=as.character(EarthImpact$CraterName), cex=1)

#Plot checking categories in X and Y axis by colors           by changing the column name in this part ↓
plot(Impact.iso$points, type="n")
text(Impact.iso$points, labels=as.character(EarthImpact$CraterName), cex=1, col=as.numeric(EarthImpact$TargetRock))
legend(-0.4, -0.3, legend=unique(EarthImpact$Continent), text.col = c(5,6,4,2,1,3))

#Checking a specific observation (crater). Barringer is the third one on the data set.
Impact.iso$points[3,]

#Zooming in the plot based on Barringer's points in X and Y axis.
plot(Impact.iso$points, type="n", xlim=c(-0.02,0),ylim=c(0.18,0.195))
text(Impact.iso$points, labels=as.character(EarthImpact$CraterName), cex=1, col=as.numeric(EarthImpact$TargetRock))



