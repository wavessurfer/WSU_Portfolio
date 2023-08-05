#A thorough PCA analysis consists of: 
#  1. A nice display of the pairwise correlations between the variables (use corrplot).
#  2. A discussion of what the first few PC's are measuring.  You might also want to include plots/graphs illustrating the variable loadings on the first few components.
#  3. Some nice graphical displays of the results, e.g. biplots and plots of the PC scores (2-D and/or 3-D) with appropriate labeling/coloring .  
#  4. Identification of observations that standout and a discussion of what makes these players unique.

library(readr)
Places <- read_csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2021 FALL/DSCI 415 Unsupervised Learning/Task2_PCA/Places.csv")
View(Places)

#Step 1: PCA is for numerical variables only. Therefore, only work with relevant columns
Places_subset <- Places[, -c(1,11,12)]
View(Places_subset)

#Step2: PCA scaling
Places_PCA <- princomp(Places_subset, cor=TRUE)
Places_PCA
names(Places_PCA)

#Step3: Importance of Components: Proprotion of the varianced for each component
summary(Places_PCA)

#Step4: Scree Plot: tells you the relevant components
Places_PCA$scores
plot(Places_PCA$scores)
plot(Places_PCA, type="bar", main="Scree Plot for Places Data")
plot(Places_PCA, type="line", main="Scree Plot for Places Data")


#Step5: Check the variables influencing each component
Places_PCA$loadings

loadplot <- function (x, variables = 1:min(5, dim(x)[2]), nbars = 6, ...) 
{
  p <- dim(x)[1]
  q <- dim(x)[2]
  on.exit(par(oldpar))
  oldpar <- par(mfrow = c(length(variables), 1), cex = 0.75, 
                pty = "m")
  par(cex = 0.75)
  vnames <- dimnames(x)[[1]]
  cnames <- dimnames(x)[[2]]
  if (nbars > p) 
    nbars <- 1:p
  else if (nbars < 1) 
    nbars <- 1
  else nbars <- 1:nbars
  for (i in variables) {
    xi <- x[, i]
    barplot(xi, names = vnames, main = cnames[i], density = 20, 
            col = "blue", ...)
    abline(h=0)
  }
  invisible()
}

#Variables = relevant components from scree plot
loadplot(Places_PCA$loadings, variables = 1:2)

#Step6: Plot the scores to find clusters
plot(Places_PCA$scores, type="n")
text(Places_PCA$scores, labels = as.character(Places$City), cex = 0.75)

#Step7: Biplot shows what variables drag each observation
biplot(Places_PCA)



#BreastCancer Dataset
BreastDiag <- read_csv("BreastDiag.csv")
View(BreastDiag)

BreastDiag_Subset <-BreastDiag[,c(-1)]
View(BreastDiag_Subset)

Cancer_PCA <- princomp(BreastDiag_Subset, cor=TRUE)
plot(Cancer_PCA$scores)
plot(Cancer_PCA, type="bar", main="Scree Plot for BreastDiag Data")
plot(Cancer_PCA, type="line", main="Scree Plot for BreastDiag Data")

loadplot(Cancer_PCA$loadings, variables = 1:3)

plot(Cancer_PCA$scores, type="n")
text(Cancer_PCA$scores, labels = as.character(BreastDiag$Diagnosis), cex = 0.75)

biplot(Cancer_PCA)


#Gene Dataset
Alontop <- read_csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2021 FALL/DSCI 415 Unsupervised Learning/Task2_PCA/Alontop.csv")
View(Alontop)

library(corrplot)
alo.cor <- Alontop[,c(3:94)]

#correlation plot
corrplot(cor(alo.cor), order="hclust")

Genes_PCA <- prcomp(alo.cor, cor=TRUE)
names(Genes_PCA)
summary(Genes_PCA)

plot(Genes_PCA$x, type="n")
text(Genes_PCA$x, labels = as.character(Alontop$TissueType), cex = 0.75)

biplot(Genes_PCA)


#NFL Dataset
Passing <- read_csv("2020 NFL Passing Statistics.csv")
View(X2020_NFL_Passing_Statistics)

Passing_Subset <- Passing[,c(-1,-2,-10,-12,-16)]
View(Passing_Subset)

corrplot(cor(Passing_Subset), order = "hclust")

Pass_PCA <- princomp(Passing_Subset, cor=TRUE)
plot(Passing_PCA, type="line", main="Scree Plot for NFL QB Data")

loadplot(Passing_PCA$loadings, variables = 1:3)

biplot(Passing_PCA)

plot(Passing_PCA$scores, type = "n")
text(Passing_PCA$scores, labels = as.character(Passing$Player))
plot3d(Pass_PCA$scores[,1],Pass_PCA$scores[,2],Pass_PCA$scores[,3])


Kicking <- read_csv("2020 NFL Kicking Statistics.csv")
spec(Kicking)
View(Kicking)

Kicking_Subset <- Kicking[,c(3,11,12,15,18,21,24,27,30,33)]
View(Kicking_Subset)

#make sure corrplot package is loaded
corrplot(cor(Kicking_Subset), order = "hclust")

Kick_PCA <- princomp(Kicking_Subset, cor=TRUE)
plot(Kick_PCA, type="line", main="Scree Plot for NFL Kicking Data")

#make sure the loadplot function is loaded
loadplot(Kick_PCA$loadings, variables = 1:2)

biplot(Kick_PCA)

plot(Kick_PCA$scores, type = "n")
text(Kick_PCA$scores, labels = as.character(Kicking$Player))


#Trying to make a 3D plot
C1 <- Kick_PCA$scores[,1]
C2 <- Kick_PCA$scores[,2]
C3 <- Kick_PCA$scores[,3]

plot3d(C1,C2,C3)

Kicking2 <- read.table(file="2020 NFL Kicking Statistics.txt", header=TRUE)
