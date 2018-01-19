package Common.ScalaChem.Test

import Common.ScalaChem.Infrastructure.IMolecule

import scala.collection.mutable.ListBuffer

class TestMethod( func : IMolecule => Unit) {
   def Function(mol : IMolecule){
     return func(mol);
   }
}

class TestRunner {

  var items : ListBuffer[TestMethod] =  new ListBuffer[TestMethod]();

  def inject(t : TestMethod): Unit ={
      items += t;
  }

  private def run_internal(molecule : IMolecule,max_levels : Int, curr_level : Int): Unit = {
    println("Currently at level :" + curr_level.toString)
    if(curr_level > max_levels)return;

    for(i <- 0 to this.items.length - 1)
      this.items(i).Function(molecule);

    this.run_internal(molecule,max_levels, curr_level + 1)
  }

  def run(mol : IMolecule,max_levels : Int){
    return this.run_internal(mol,max_levels,0)
  }
}