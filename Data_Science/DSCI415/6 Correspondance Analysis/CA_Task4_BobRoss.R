library(readr)
BobRossCommon <- read_csv("BobRossPaintings.csv")
View(BobRossCommon)
names(BobRossCommon)
bobross.mat = BobRossCommon[,-c(1:2)]  # Get rid of Title variables
bobross.mat = apply(bobross.mat,2,as.factor)

bobross.mat2 = BobRossCommon[,-c(1:3)]  # Get rid of Title variables
bobross.mat2 = apply(bobross.mat2,2,as.factor)


View(bobross.mat2)
library(FactoMineR)
library(factoextra)
bobross.MCA = MCA(bobross.mat2)
View(bobross.MCA)
#plot showing individuals and variables
plot(bobross.MCA)
#plot showing variables
plot(bobross.MCA,invisible=c("ind"))
plot(bobross.MCA,invisible=c("ind"), xlim=c(-2,0),ylim=c(1,2))
#plot showing individuals
plot(bobross.MCA,invisible=c("var"))

#Finding specific individuals
X.mca.supp = MCA(bobross.mat, quali.sup= 1)
plot(X.mca.supp,invisible=c("ind","var"))
plot(X.mca.supp,invisible=c("ind","var"), xlim=c(-2,0),ylim=c(1,2))

var <- get_mca_var(bobross.MCA)
barplot(sort(var$contrib[,1], decreasing = TRUE)[1:10])
barplot(sort(var$contrib[,2], decreasing = TRUE)[1:10])
