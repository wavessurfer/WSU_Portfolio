library(readr)
Goblets <- read_csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2021 FALL/DSCI 415 Unsupervised Learning/Goblets.csv")
View(Goblets)

var(Goblets)

Std_Goblets <- scale(Goblets)
View(Std_Goblets)

var(Std_Goblets)
cor(Goblets)

pca = princomp(Goblets, cor = TRUE)
pca

names(pca)

pca$scores

plot(pca$scores)

summary(pca)

plot(pca, type="bar", main="Scree Plot for Goblet Data")

plot(pca, type="line", main="Scree Plot for Goblet Data")

pca$loadings

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

loadplot(pca$loadings, variables = 1:3)

plot(pca$scores, main="Plot of PC1 vs PC2 for Goblet Data")

biplot(pca)

Xsvd = svd(X)

U = Xsvd$u
V = Xsvd$v
D = diag(Xsvd$d)

U2 = U[,1:2]
D2 = diag(Xsvd$d[1:2])
V2 = V[,1:2]

U3 = U[,1:3]
D3 = diag(Xsvd$d[1:3])
V3 = V[,1:3]

library(png)
library(RCurl)
myurl = "http://www.statsclass.org/dsci415/Datasets/Girl_Image.png"
girl_image =  readPNG(getURLContent(myurl))
girl_mat=girl_image[,,1] # will hold the grayscale values 

dim(girl_mat)

girl_mat =apply(girl_mat, 2, rev) # otherwise the image will be rotated
image(t(girl_mat), col  = gray((0:341)/341)) # plot in grayscale

girl_matsvd <- svd(girl_mat)
girl_matsvd

image.svd = function(Xsvd,k=10){
  Dk = diag(Xsvd$d[1:k])
  Uk = Xsvd$u[,1:k]
  Vk = Xsvd$v[,1:k]
  Xk = Uk%*%Dk%*%t(Vk)
  p = dim(Xsvd$u)[1]
  x = seq(1:p)
  y = x
  image(x,y,t(Xk),col=gray((0:(p-1))/(p-1)))
  title(paste(k," Dimensional Approximation"))
}

image.svd(girl_matsvd, k = 75)
