package Common.ScalaChem.MolGraph

import Common.ScalaChem.Infrastructure.IAtom

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Isomorphism {
  private var data = new mutable.ListBuffer[ListBuffer[(IAtom,IAtom)]]();

  private def substructure_match(base : Molecule,
                         to_find : Molecule,
                         list : ListBuffer[(IAtom,IAtom)]): Unit = {
    if (base.length < to_find.length) {
      return (false, null)
    } else {
      if (to_find.length == 0) {
        data.append(list);
      }
      for (atom <- to_find) {
        for (match_atom <- base) {
          if (matches(atom, match_atom)) {

            var newBaseMap = base.clone_with_map();
            var newBase = newBaseMap._2

            var newSearchMap = to_find.clone_with_map();
            var newSearch = newSearchMap._2;

            var list_clone = list.clone().asInstanceOf[ListBuffer[(IAtom, IAtom)]]
            list_clone.append((atom, match_atom))
            substructure_match(newBase.asInstanceOf[Molecule], newSearch.asInstanceOf[Molecule], list_clone)
          }
        }
      }
    }
  }

   def substructure_matches(base : Molecule,
                           to_find : Molecule): mutable.ListBuffer[ListBuffer[(IAtom,IAtom)]] ={
    this.data = new mutable.ListBuffer[ListBuffer[(IAtom,IAtom)]]();
    this.substructure_match(base,to_find,new ListBuffer[(IAtom,IAtom)]);
    return this.data;
  }

    //This should be a real comparision with charge and stuff..
    def matches(atom1 : IAtom, atom2 : IAtom): Boolean={
      return atom1.Element == atom2.Element
    }
  }
