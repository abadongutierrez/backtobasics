import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class PrimesIterator implements Iterator<Integer> {
 
 static private LinkedList<Integer> primes=new LinkedList<Integer>();
 private ListIterator<Integer> primesiter;

 public PrimesIterator() {
  //We have to check if we have the list initialized. If not, we insert two obvious ones.
  //The rest we can compute on our own
  
  primesiter=primes.listIterator();
  if (!primesiter.hasNext()) {
   primesiter.add(2);
   primesiter.add(3);
   primesiter.previous();
   primesiter.previous();
  }
 }
 
 public boolean hasNext() {
  //There is always a prime bigger than our current one.
  return true;
 }

 private static boolean isPrime(int arg) {
  // We assume that we are calling this method only to find next prime.
  // This way we don't need to worry about the list contents.
  int limit=(int) Math.sqrt(arg);
  int temp;
  ListIterator<Integer> tempprimesiter=primes.listIterator();
  while (tempprimesiter.hasNext()) {
   temp=tempprimesiter.next();
   if (temp>limit)
    return true;
   if ((arg % temp)==0)
    return false;
  }
  return true;
 }
 
 private void computeNext() {
  //We already have the only even prime number, so we seek only odd ones;
  int temp;
  temp=primesiter.previous()+2;
  primesiter.next();
  while (!PrimesIterator.isPrime(temp)) {
   temp++;
  }
  primesiter.add(temp);
  primesiter.previous();
 }
 
 
 public Integer next() {
  //If we already have one computed, there's no point of computing it again.
  //Otherwise, we'll compute one and store it for later.
  
  if (!primesiter.hasNext())
   this.computeNext();
  return primesiter.next();
 }


 public void remove() {
  
 }
 
 
 
}