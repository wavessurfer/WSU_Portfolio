library(readr)
Suicide <- read_csv("Suicide.csv")
View(Suicide)

Suicide_no_labels <- Suicide[,-c(1)]

suicide_proportions <- Suicide_no_labels / sum (Suicide_no_labels)

options(digits = 5)

suicide_row_prop <- apply(suicide_proportions, 1, sum)
suicide_col_prop <- apply(suicide_proportions, 2, sum)
suicide_matrix <- as.matrix(Suicide_no_labels)
mosaicplot(suicide_matrix, color = T, main = "Suicide method vs Gender-Age")

rdiag = diag(1/sqrt(suicide_row_prop))
cdiag = diag(1/sqrt(suicide_col_prop))

suicide_proportions = as.matrix(suicide_proportions)
suicide_row_prop = as.matrix(suicide_row_prop)
suicide_col_prop = as.matrix(suicide_col_prop)

C = rdiag%*%(as.matrix(suicide_proportions) -suicide_row_prop%*%t(suicide_col_prop))%*%cdiag
C

suicide.sva = svd(C)
suicide.sva

delta = suicide.sva$d
U = suicide.sva$u[,1:2]
V = suicide.sva$v[,1:2]

U[,1] = delta[1]*U[,1]/sqrt(suicide_row_prop)
U[,2] = delta[2]*U[,2]/sqrt(suicide_row_prop)
V[,1] = delta[1]*V[,1]/sqrt(suicide_col_prop)
V[,2] = delta[2]*V[,2]/sqrt(suicide_col_prop)
CA = rbind(U,V)
inertia = sum(delta^2)
inertia

#the first coordinate explains 52% of the variation
per1 = delta[1]^2/inertia
per1

#the second coordinate explains 38% of the variation
per2 = delta[2]^2/inertia
per2

options(digits=5)

plot(CA[,1],CA[,2],type="n",xlab = paste("coord 1% inertia =",format(per1*100)),
       + ylab = paste("coord 2% inertia =",format(per2*100)))
text(CA[,1],CA[,2],labels=c(dimnames(Suicide)[[1]],dimnames(Suicide)[[2]]))
abline(h=0,lty=2)
abline(v=0,lty=2)
title(main="Correspondence Analysis for West German Suicides (1974 - 1977)")
