package test.impl.operation.impl;

import test.impl.operation.CA0Op;
import test.impl.operation.CA1Op;
import test.impl.operation.CA2Op;
import test.impl.operation.CA3Op;
import test.impl.operation.CA4Op;
import test.impl.operation.CA5Op;
import test.impl.operation.CA6Op;
import test.impl.operation.CA7Op;
import test.impl.operation.CA8Op;
import test.impl.operation.CA9Op;
import test.impl.operation.CB0Op;
import test.impl.operation.CB1Op;
import test.impl.operation.CB2Op;
import test.impl.operation.CB3Op;
import test.impl.operation.CB4Op;
import test.impl.operation.CB5Op;
import test.impl.operation.CB6Op;
import test.impl.operation.CB7Op;
import test.impl.operation.CB8Op;
import test.impl.operation.CB9Op;
import testmaprelations.CB1;
import testmaprelations.revisitor.TestmaprelationsRevisitor;

public class CB1OpImpl implements CB1Op {
  private TestmaprelationsRevisitor<CA0Op, CA1Op, CA2Op, CA3Op, CA4Op, CA5Op, CA6Op, CA7Op, CA8Op, CA9Op, CB0Op, CB1Op, CB2Op, CB3Op, CB4Op, CB5Op, CB6Op, CB7Op, CB8Op, CB9Op> rev;

  private CB1 obj;

  public CB1OpImpl(CB1 obj,
      TestmaprelationsRevisitor<CA0Op, CA1Op, CA2Op, CA3Op, CA4Op, CA5Op, CA6Op, CA7Op, CA8Op, CA9Op, CB0Op, CB1Op, CB2Op, CB3Op, CB4Op, CB5Op, CB6Op, CB7Op, CB8Op, CB9Op> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
