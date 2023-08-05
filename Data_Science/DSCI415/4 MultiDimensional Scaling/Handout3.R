

library(ade4)
data(zealand)
View(zealand)
zealand$road

distNZ <- zealand$road
nz.mds <- cmdscale(distNZ, k=2, eig=T)

names(nz.mds)

nz.mds$eig

nz.mds$points

plot(nz.mds$points, type = "n")
text(nz.mds$points, row.names(nz.mds$points))

plot(-nz.mds$points[,2],nz.mds$points[,1],type="n",xlim=c(-300,300))
text(-nz.mds$points[,2],nz.mds$points[,1],row.names(distNZ),cex=.7)

dist2 = as.matrix(dist(nz.mds$points))  # distance matrices are lower triangular
dist2

library(MASS)

distNZ2 = as.dist(distNZ)
nz.samm <- sammon(distNZ2, k=3)

names(nz.samm)
nz.samm$stress

plot(-nz.samm$points[,2],nz.samm$points[,1],type="n",xlim=c(-200,200))
text(-nz.samm$points[,2],nz.samm$points[,1],row.names(nz.samm$points),cex=.7)


