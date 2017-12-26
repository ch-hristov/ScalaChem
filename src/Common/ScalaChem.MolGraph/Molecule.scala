package ScalaChem.MolGraph

import ScalaChem.Infrastructure.{IAtom, IMolecule}

/**
 * Corresponds to a single record from the PubChem Compound database.
 * The PubChem Compound database is constructed from the Substance database using a standardization and deduplication process. 
 * Each Compound is uniquely identified by a CID.
 */
class Molecule extends IMolecule( ) {
  override var Atoms: List[IAtom] = _

  override def Connect(a: IAtom, b: IAtom): Unit = {

  }
}