library(readr)
TennisRacquets <- read_csv("TennisRacquets.csv")
View(TennisRacquets)
Racquets <- TennisRacquets[,c(-1)]
View(Racquets)

#pairwise correlations between the variables
library(corrplot)
corrplot(cor(Racquets), order = "hclust", method = "number")

#PCA scaling
PCA <- princomp(Racquets, cor=TRUE)

#Importance of Components: Proportion of the variances for each component
summary(PCA)

#Scree Plot: tells you the relevant components
plot(PCA$scores)
plot(PCA, type="line", main="Scree Plot")

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
  par(mfrow = c(1,1))
}

#Variables = relevant components from scree plot
loadplot(PCA$loadings, variables = 1:2)

#Step6: Plot the scores to find clusters
plot(PCA$scores, type="n")
text(PCA$scores, labels = as.character(TennisRacquets$Racquet), cex = 0.75)

biplot(PCA)

Racq <- scale(Racquets)
library(cluster)
library(factoextra)
fviz_nbclust(Racq, kmeans, method = "wss", k.max = 10)
fviz_nbclust(Racq, kmeans, method = "silhouette", k.max = 10)
fviz_nbclust(Racq, kmeans, method = "gap_stat", k.max = 10)

de <- dist(Racq, method = "euclid")
deward <- hclust(de, method = "ward.D")

plot(deward, labels = TennisRacquets$Racquet)  
grps = cutree(deward, k=6)  

plot(silhouette(grps, de))

clust.grps = function(X,grps,parcoord=F,suppress=F) {
  require(MASS)
  k = length(unique(grps))
  p = dim(X)[[2]]
  Xmeans = matrix(0,nrow=length(unique(grps)),ncol=p+1)
  X = as.data.frame(X)
  for (i in 1:k){
    cat("\n")
    cat(paste("Cluster",i,"\n"))
    cat("=======================================================================\n")
    if (suppress==F){
      cat(row.names(X)[grps==i])
      cat("\n\n")}
    cat("Variable means in this cluster are:\n")
    cat("----------------------------------------------------------------------\n")
    print(apply(X[grps==i,],2,mean))
    Xmeans[i,]=c(apply(X[grps==i,],2,mean),as.numeric(i))
    cat("\n\n")
    
  } 
  if (parcoord) {
    par(mfrow=c(2,1))
    parcoord(Xmeans[,-(p+1)],col=as.numeric(Xmeans[,(p+1)])+2,
             lwd=2,var.label=T)
    parcoord(X,col=as.numeric(grps)+2,lwd=2)
  }
  par(mfrow = c(1,1))
  
}
clust.grps(Racq, grps, parcoord=T)

plot(PCA$scores, type="n")
text(PCA$scores, labels = as.character(TennisRacquets$Racquet), cex = 0.75, col = grps )

