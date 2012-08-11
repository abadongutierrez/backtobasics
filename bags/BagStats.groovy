class Bag<T> implements Iterable<T>, Iterator<T> {
    List<T> elements = new ArrayList<T>()
    int iterationIndex = -1

    void add(T item) {
        elements.add(item)
    }

    boolean isEmpty() {
        return elements.size() == 0
    }

    int size() {
        return elements.size()
    }

    // {{{ Iterable methdos
    Iterator<T> iterator() {
        println "Hey, llamarion iterator!"
        iterationIndex = -1
        return this
    }
    // }}}

    // Iterator methods
    boolean hasNext() {
        if ((iterationIndex + 1) >= this.size()) {
            return false
        }
        true
    }

    T next() {
        println "Next!"
        return elements.get(++iterationIndex)
    }

    void remove() {
    }
    // }}}
}

// -------------------------------------------------------------------------------------------------

bag = new Bag<Double>()

bag.add(100.0)
bag.add(99)
bag.add(101)
bag.add(120)
bag.add(98)
bag.add(107)
bag.add(109)
bag.add(81)
bag.add(101)
bag.add(90)

N = bag.size()
sum = 0.0

for (double x: bag) {
    sum += x
}
mean = sum/N

sum = 0.0

for (double x: bag) {
    sum += (x - mean) * (x - mean)
}
println "sum: ${sum}"
println "N: ${N}"
std = Math.sqrt(sum/(N - 1))

println "Mean: ${mean}"
println "Std dev: ${std}"