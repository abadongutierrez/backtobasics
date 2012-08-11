
N = 120
p = 2
class Item {
    int num
    boolean marked
}
list = []
primeNumbers = [2]

for (int i = 2; i <= N; ++i) {
   if (i == p) list << new Item(num: i, marked: true)
   else list << new Item(num: i, marked: false)
}

println "${primeNumbers}, p:${p}"
while ((p = findNextP(p)) != null) {
    println "${primeNumbers}, p:${p}"
    for (int i = p; i <= 120; i += p) {
        findNMark(i)
    }
}

for (int i = 0; i < list.size(); ++i) {
    if (!list.get(i).marked) {
        primeNumbers << list.get(i).num
    }
}

def findNextP(int antp) {
    for (int i = 0; i < list.size(); ++i) {
        if (!list.get(i).marked && list.get(i).num > p) {
            primeNumbers << list.get(i).num
            return list.get(i).num
        }
    }
    null
}

def findNMark(int num) {
    for (int i = 0; i < list.size(); ++i) {
        if (list.get(i).num == num) {
            list.get(i).marked = true
            return
        }
    }
}

println "${primeNumbers}"
