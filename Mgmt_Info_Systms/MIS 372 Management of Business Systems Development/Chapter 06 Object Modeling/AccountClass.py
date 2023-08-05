class Account:
    # Construct an Account object 
    def __init__(self, id, balance = 100, annualInterestRate = 0):
        self.__id = id
        self.__balance = balance
        self.__annualInterestRate = annualInterestRate

    def getId(self):
        return self.__id

    def getBalance(self):
        return self.__balance

    def getAnnualInterestRate(self):
        return self.__annualInterestRate

    def getMonthlyInterestRate(self):
        return self.__annualInterestRate / 12

    def setPreviousPrice(self, previousPrice):
        self.previousPrice = previousPrice

    def setCurrentPrice(self, currentPrice):
        self.currentPrice = currentPrice

    def withdraw(self, amount):
        self.__balance -= amount

    def deposit(self, amount):
        self.__balance += amount

    def getMonthlyInterest(self):
        return self.__balance * self.getMonthlyInterestRate()

