package top.marchand.sealed.utilities.cases;

public sealed interface SealedInterface {
  void doJob();

  final class A implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("A does the job");
    }
  }
  final class B implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("B does the job");
    }
  }
  final class PRIVATE implements SealedInterface {
    private String reason;
    private PRIVATE() {
      super();
    }
    public PRIVATE(String reason) {
      this();
      this.reason = reason;
    }
    @Override
    public void doJob() {
      System.out.println("PRIVATE does the job with "+ reason);
    }
  }
  record C(Integer x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("C prints "+x());
    }
  }
  record D(int x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("D prints "+x());
    }
  }
  record E(boolean x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("E prints "+x());
    }
  }
  record F(char x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("F prints "+x());
    }
  }
  record G(byte x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("G prints "+x());
    }
  }
  record H(short x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("H prints "+x());
    }
  }
  record I(long x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("I prints "+x());
    }
  }
  record J(float x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("J prints "+x());
    }
  }
  record K(double x) implements SealedInterface {
    @Override
    public void doJob() {
      System.out.println("K prints "+x());
    }
  }
}
