
LIMIT = 100

def divideByItself(int num) {
    return num % num == 0
}

def divideByOthers(int num) {
    for (int i = 2; i <= 9; ++i) {
        if (i == num) continue
        if (num % i == 0) return true
    }
    return false
}

for (int i = 2; i < LIMIT; ++i) {
    if (divideByItself(i) && !divideByOthers(i)) {
        print "${i} "
    }
}

println "\n."
