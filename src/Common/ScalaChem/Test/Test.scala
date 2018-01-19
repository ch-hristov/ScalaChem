package Common.ScalaChem.Test

import Common.ScalaChem.Infrastructure.IMolecule

import scala.collection.mutable.ListBuffer

class Test( func : (IMolecule)) {
   def Function(){return func;}
}

class TestRunner {

  var items : ListBuffer[Test] =  new ListBuffer[Test]();

  def inject(t : Test): Unit ={
      items += t;
  }

  private def run_internal(max_levels : Int, curr_level : Int): Unit = {
    if(curr_level > max_levels)return;

    for(i <- 0 to this.items.length){
      this.items(i).Function();
    }
    this.run_internal(max_levels, curr_level + 1)
  }

  def run(max_levels : Int){
    return this.run_internal(max_levels,0)
  }
}