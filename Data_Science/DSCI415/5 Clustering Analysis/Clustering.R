library(readr)
IllicitDrug <- read_csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2021 FALL/DSCI 415 Unsupervised Learning/5 Clustering Analysis/IllicitDrug.csv")
View(IllicitDrug)
  
#Step 1: Relevant columns (numerical)
IllDrug <- IllicitDrug[,-1]

#Step 2: Scale values
IllDrug <- scale(IllDrug)

View(IllDrug)

#Step3: Measure distances
de <- dist(IllDrug,method="euclid")
summary(de)

#Step4: Cluster with your preferred linkage
desing <- hclust(de,method= "sing")
names(desing)
plot(desing, labels = IllicitDrug$State)

deave <- hclust(de,method = "ave")
plot(deave, labels = IllicitDrug$State)

deward <- hclust(de, method = "ward.D")
plot(deward, labels = IllicitDrug$State)

#Step5: Cutting the tree (cluster Dendogram): Check what states are grouped together in the specified amount of clusters ( k = i)
drug.clusters <- cutree(deward, k=6)
IllicitDrug$State
drug.clusters

library(factoextra)
fviz_nbclust(IllDrug, kmeans, method = "wss", k.max = 10)
