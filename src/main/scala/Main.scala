

/** Une classe liste FIFO. */
case class Queue[T](in:List[T] = Nil, out:List[T] = Nil) {
  /** Ajoute un élément `x` en tête. */
  def enqueue(x:T):Queue[T] = in match {
    case Nil => Queue(x::Nil,out)
    case _ => Queue( x::in, out)
  }

  /** Retire le dernier élément. */
  def dequeue():(T,Queue[T]) = {
    if (out.isEmpty)
      (in.last, Queue(out, in.reverse.tail))
    else
      (out.head, Queue(in, out.tail))

  }
  /** Accès au premier élément, s'il existe (dernier élément entré). */
  def headOption():Option[T] = in match {
    case Nil => None
    case _ => Option(in.last)
  }
  /** Vrai si la liste est vide. */
  def isEmpty:Boolean = in.isEmpty && out.isEmpty
}

object fifo {


}

object testFifo {



  def main(args: Array[String]): Unit = {
    println("Hello world!")

    val A = Queue[Int](Nil, Nil) // in = Nil, out = Nil
    println("A = "+ A)
    val B = A.enqueue(1) // = Queue(1->Nil, Nil)
    println("B = "+ B)
    val C = B.enqueue(2) // = Queue(2->1->Nil, Nil)
    println("C = "+ C)
    val D = C.enqueue(3) // = Queue(3->2->1->Nil, Nil)
    println("D = "+ D)
    val E = D.dequeue() // = (1, Queue(Nil, 2->3->Nil) ici 'in' est inversée et placée en `out`
    println("E = "+ E)
    val F = E._2.enqueue(4) // = Queue(4->Nil, 2->3->Nil)
    println("F = "+ F)
    val G = F.enqueue(5) // = Queue(5->4->Nil, 2->3->Nil)
    println("G = "+ G)
    val H = G.dequeue() // = (2, Queue(5->4->Nil, 3->Nil)
    println("H = "+ H)
    val I = H._2.dequeue() // = (3, Queue(5->4->Nil, Nil))
    println("I = "+ I)
    val J = I._2.dequeue() // = (4, Queue(Nil, 5->Nil))
    println("J = "+ J)
    val K = J._2.dequeue() // = (5, Queue(Nil, Nil))
    println("K = "+ K)


    println(D.headOption())
    println(A.isEmpty)
    println(B.isEmpty)
  }
}