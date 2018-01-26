package Common.ScalaChem.MolGraph

import Common.ScalaChem.Infrastructure.IAtom

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Isomorphism {
  private var data = new mutable.ListBuffer[(IAtom,IAtom)]();
  private var cnt = 0;

  private var matchedA = mutable.Map[IAtom,Boolean]()
  private var matchedB = mutable.Map[IAtom,Boolean]()

  private def substructure_match(
                                length : Int,
                                  base : mutable.Map[IAtom,Boolean],
                         to_find : mutable.Map[IAtom,Boolean],
                         matchedA : IAtom,
                         matchedB : IAtom,
                         list : ListBuffer[(IAtom,IAtom)]): ListBuffer[(IAtom,IAtom)] = {
    if(to_find.forall(x=>x._2 == true))
      return list;

    var con = matchedA.connections()

    var l = ListBuffer[(IAtom,IAtom)]()

    for(i <- con){
      if(!base(i.To)) {
        var conj = matchedB.connections()
        for (j <- conj) {
          if(!to_find(j.To)) {
            var at = i.To
            var gt = j.To
            if (matches(at, gt)) {
              var basec = base.clone()
              var findc = to_find.clone()
              var lc = list.clone()
              lc.append((at, gt))
              basec(at) = true
              findc(gt) = true;
              var ans = substructure_match(length,basec, findc, at, gt, lc)
              if(ans != null){
                return ans
              }
            }
          }
        }
      }
    }
    return null;

  }

   def substructure_matches(base : Molecule,
                           to_find : Molecule): mutable.ListBuffer[(IAtom,IAtom)] ={
     for(i <- base.Graph.keys){
       matchedA(i)=false;
     }
     for(i <- to_find.Graph.keys){
       matchedB(i)=false;
     }
    this.data =new mutable.ListBuffer[(IAtom,IAtom)]();
     for(i <- base.Graph){
       for(j <- to_find.Graph){
         if(i._1.connections().length == j._1.connections().length) {
           var l = this.substructure_match(to_find.Graph.size, matchedA, matchedB, i._1, j._1,
                                                               new ListBuffer[(IAtom, IAtom)]);
           if (l != null && l.length > this.data.length) {
             this.data = l;
           }
         }
       }
     }

    return this.data;
  }

    //This should be a real comparision with charge and stuff..
    def matches(atom1 : IAtom, atom2 : IAtom): Boolean={
      return atom1.Element == atom2.Element && atom1.connections().length == atom2.connections().length;
    }
  }
