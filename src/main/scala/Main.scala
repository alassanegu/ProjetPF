
/** Une classe liste FIFO. */
case class Queue[T](in:List[T] = Nil, out:List[T] = Nil) {
  /** Ajoute un élément `x` en tête. */
  def enqueue(x:T):Queue[T] = ???
  /** Retire le dernier élément. */
  def dequeue():(T,Queue[T]) = ???
  /** Accès au premier élément, s'il existe (dernier élément entré). */
  def headOption():Option[T] = ???
  /** Vrai si la liste est vide. */
  def isEmpty:Boolean = in.isEmpty && out.isEmpty
}
object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
  }
}