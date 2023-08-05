
#Mushroom Data
library(readr)
Mushrooms <- read.csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2021 FALL/DSCI 415 Unsupervised Learning/Mushrooms.csv", stringsAsFactors = TRUE)
View(Mushrooms)

names(Mushrooms)
summary(Mushrooms)

mush.reduced <- Mushrooms[-c(1,12)]
summary(mush.reduced)

library(cba)
library(MASS)
mush.dummy = as.data.frame(as.dummy(mush.reduced))	
View(mush.dummy)

implot(as.matrix(mush.dummy))

library(proxy)

mush.dist = dist(mush.dummy,method="Jaccard")
summary(as.numeric(mush.dist))

#Metric MDS method
mush.mds = cmdscale(mush.dist, k=3)
mush.mds

pairs.grps2 = function (x, groups, cex = 0.7) 
{
  pairs(x, panel = function(x, y, ...) {
    text(x, y, as.character(groups), cex = cex, col = as.numeric(groups) + 
           2)
  })
}

pairs.grps2(mush.mds,groups=Mushrooms$Poisonous,cex=.7)

library(rgl)

plot3d(mush.mds, type = "n")
text3d(mush.mds,text=as.character(Mushrooms$Poisonous),col=as.numeric(Mushrooms$Poisonous)+2)

#Non-metric MDS
mush.isol = isoMDS(mush.dist,k=1)


Statplot(mush.iso$points)

mush.iso2 = isoMDS(mush.dist,k=2)

plot(mush.iso2$points,xlab="Dim 1",ylab="Dim 2",main="Non-metric MDS for Mushrooms",type="n")
text(mush.iso2$points,as.character(Mushrooms$Poisonous),
       col=as.numeric(Mushrooms$Poisonous)+2)


mush.iso3 = isoMDS(mush.dist,k=3)

plot3d(mush.iso3$points,xlab="Dim 1",ylab="Dim 2",zlab="Dim 3",type="n")
> text3d(mush.iso3$points,text=as.character(Mushrooms.train$Poisonous),
         col=as.numeric(Mushrooms.train$Poisonous)+2)
