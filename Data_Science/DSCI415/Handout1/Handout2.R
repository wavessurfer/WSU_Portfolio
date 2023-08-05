#9/7/2021
View(City77)
X = as.matrix(City77[,c(16,18,19)])
xd = X[9,] #extract data for Detroit (9th row in the data frame)
xd

xm = X[47,] #extract data for Minneapolis (47th row in the data frame)
xm

t(xd-xm) %*%(xd-xm) #Euclidean distance squared

sX = scale(X)
sxd = sX[9,] #Detroit
sxd

sxm = sX[47,]
sxm
sqrt(t(sxd-sxm)%*%(sxd-sxm))


#9/9/2021
library(readr)
DTCTesting <- read_csv("C:/Users/nn1448lr/OneDrive - MNSCU/Classes/2021 FALL/DSCI 415 Unsupervised Learning/DTCTesting.csv")
View(DTCTesting)

#Loading tidyverse
library(tidyverse)

install.packages("tidyverse", type="binary")

#Selecting only Yes/No
DTCTestingYesNo <- (DTCTesting
                    %>% select(Q8_HeardofDTCTesting, Q9_MadeReferralforDTCTesting, Q12_AwareOfLocalDTCTesting, Q20_KnowHowToRefer)
)

#Load fastDummies to create dummy variables
library(fastDummies)
DTCTestingYesNo_Dummy = dummy_cols(DTCTestingYesNo)

#Use only dummy cols
DTCTestingYesNo_Dummy <- DTCTestingYesNo_Dummy[,5:12]

#Convert entire data.frame to logical
DTCTestingYesNo_DummyTF <- ifelse(DTCTestingYesNo_Dummy == 1, TRUE, FALSE)

#Load proxy
library(proxy)

#Similarity/Dis-similarity measures via Jaccard

simil(DTCTestingYesNo_DummyTF, method="Jaccard") 
dist(DTCTestingYesNo_DummyTF, method="Jaccard") 

