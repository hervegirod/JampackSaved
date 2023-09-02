package Jampack;

/**
 * Print prints numbers, matrices, and arrays. All floating-point
 * numbers are printed in e format with field width w and d figures
 * to the left of the right of the decimal point. For the defaults
 * see <a href="Parameters.html"> Parameters </a>.
 *
 * @version Pre-alpha
 * @author G. W. Stewart
 */
public class Print {

   private static java.text.DecimalFormat fmt = new java.text.DecimalFormat();

   /**
    * Prints an int in default format.
    *
    * @param k the int value
    */
   public static void o(int k) {
      o(k, Parameters.OutputFieldWidth);
   }

   /**
    * Prints and int in a field of width w.
    *
    * @param k the first value
    * @param w the second value
    */
   public static void o(int k, int w) {
      System.out.print("\n");
      String num = Integer.toString(k);
      while (num.length() < w) {
         num = " " + num;
      }
      System.out.print(num);
      System.out.print("\n");
   }

   /**
    * Prints an integer array in default format.
    *
    * @param ia the array
    */
   public static void o(int ia[]) {
      o(ia, Parameters.OutputFieldWidth);
   }

   /**
    * Prints an integer array in fields of width w.
    *
    * @param ia the array
    * @param w the width
    */
   public static void o(int ia[], int w) {
      int n = ia.length;
      int ncp = Parameters.PageWidth / w;

      int jl = 0;
      while (jl < n) {
         int ju = Math.min(n, jl + ncp);

         System.out.print("\n");

         for (int j = jl; j < ju; j++) {
            String num = Integer.toString(ia[j]);
            while (num.length() < w) {
               num = " " + num;
            }
            System.out.print(num);
         }

         jl = jl + ncp;
      }
      System.out.print("\n");
   }

   /**
    * Prints a double in default e format.
    *
    * @param a the double
    */
   public static void o(double a) {
      o(a, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints a double in w.d e format.
    *
    * @param a the double
    * @param w the w
    * @param d the d
    */
   public static void o(double a, int w, int d) {
      System.out.print("\n");
      System.out.print(DoubletoEstring(a, w, d));
      System.out.print("\n");
   }

   /**
    * Prints an array of doubles in default e format.
    *
    * @param a the double
    */
   public static void o(double[] a) {
      o(a, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints an array of doubles in w.d e format.
    *
    * @param a the double
    * @param w the w
    * @param d the d
    */
   public static void o(double[] a, int w, int d) {

      int nc = a.length;

      int ncp = (Parameters.PageWidth) / w;

      int jl = 0;
      while (jl < nc) {
         int ju = Math.min(nc, jl + ncp);

         System.out.print("\n");

         for (int j = jl; j < ju; j++) {
            String head = Integer.toString(j);
            while (head.length() < w) {
               head = " " + head;
            }
            System.out.print(head);
         }
         System.out.print("\n");

         for (int j = jl; j < ju; j++) {
            System.out.print(DoubletoEstring(a[j], w, d));
         }
         System.out.print("\n");
         jl = jl + ncp;
      }
   }

   /**
    * Prints a 2-dimensional array of doubles in default e format.
    *
    * @param A the array
    */
   public static void o(double[][] A) {
      o(A, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints a 2-dimensional array of doubles in w.d e format.
    *
    * @param A the array
    * @param w the w
    * @param d the d
    */
   public static void o(double[][] A, int w, int d) {

      int nr = A.length;
      int nc = A[0].length;

      String temp = Integer.toString(nr - 1);
      int rfw = temp.length() + 1;

      int ncp = (Parameters.PageWidth - rfw) / w;

      int jl = 0;
      while (jl < nc) {
         int ju = Math.min(nc, jl + ncp);

         System.out.print("\n");

         String head = "";
         while (head.length() < rfw) {
            head = head + " ";
         }
         System.out.print(head);

         for (int j = jl; j < ju; j++) {
            head = Integer.toString(j);
            while (head.length() < w) {
               head = " " + head;
            }
            System.out.print(head);
         }
         System.out.print("\n");

         for (int i = 0; i < nr; i++) {
            String row = Integer.toString(i);
            while (row.length() < rfw) {
               row = " " + row;
            }
            System.out.print(row);
            for (int j = jl; j < ju; j++) {
               System.out.print(DoubletoEstring(A[i][j], w, d));
            }
            System.out.print("\n");
         }
         jl = jl + ncp;
      }
   }

   /**
    * Prints a Z in default e format.
    *
    * @param a the Z
    */
   public static void o(Z a) {
      o(a, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints a Z in w.d e format.
    *
    * @param a the Z
    * @param w the w
    * @param d the d
    */
   public static void o(Z a, int w, int d) {
      System.out.print("\n");
      System.out.print(ZtoEstring(a, w, d));
      System.out.print("\n");
   }

   /**
    * Prints an array of Z's in default e format.
    *
    * @param a the Z array
    */
   public static void o(Z[] a) {
      o(a, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints an array of Z's in w.d e format.
    *
    * @param a the Z array
    * @param w the w
    * @param d the d
    */
   public static void o(Z[] a, int w, int d) {

      int n = a.length;

      int ww = w + d + 10;
      int ncp = (Parameters.PageWidth) / ww;

      int jl = 0;
      while (jl < n) {
         int ju = Math.min(n, jl + ncp);

         System.out.print("\n");

         String head = "";

         for (int j = jl; j < ju; j++) {
            head = Integer.toString(j);
            while (head.length() < ww) {
               head = " " + head;
            }
            System.out.print(head);
         }
         System.out.print("\n");

         for (int j = jl; j < ju; j++) {
            System.out.print(ZtoEstring(a[j], w, d));
         }
         System.out.print("\n");
         jl = jl + ncp;
      }
   }

   /**
    * Prints a 2-dimensional array of Z in default e format.
    *
    * @param A the Z array
    */
   public static void o(Z[][] A) {
      o(A, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints a 2-dimensional array of Z in w.d e format.
    *
    * @param A the Z array
    * @param w the w
    * @param d the d
    */
   public static void o(Z[][] A, int w, int d) {

      int nr = A.length;
      int nc = A[0].length;

      String temp = Integer.toString(nr - 1);
      int rfw = temp.length() + 1;

      int ww = w + d + 10;
      int ncp = (Parameters.PageWidth - rfw) / ww;

      int jl = 0;
      while (jl < nc) {
         int ju = Math.min(nc, jl + ncp);

         System.out.print("\n");

         String head = "";
         while (head.length() < rfw) {
            head = head + " ";
         }
         System.out.print(head);

         for (int j = jl; j < ju; j++) {
            head = Integer.toString(j);
            while (head.length() < ww) {
               head = " " + head;
            }
            System.out.print(head);
         }
         System.out.print("\n");

         for (int i = 0; i < nr; i++) {
            String row = Integer.toString(i);
            while (row.length() < rfw) {
               row = " " + row;
            }
            System.out.print(row);
            for (int j = jl; j < ju; j++) {
               String snum = DoubletoEstring(A[i][j].re, w, d);
               if (A[i][j].im < 0) {
                  snum = snum + " - "
                     + DoubletoEstring(-A[i][j].im, d + 6, d) + "i";
               } else {
                  snum = snum + " + "
                     + DoubletoEstring(A[i][j].im, d + 6, d) + "i";
               }
               System.out.print(snum);
            }
            System.out.print("\n");
         }
         jl = jl + ncp;
      }
   }

   /**
    * Prints a Z1 in default format.
    *
    * @param z the Z1
    */
   public static void o(Z1 z) {
      o(z, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints a Z1 in w.d e format
    *
    * @param z the Z1
    * @param w the w
    * @param d the d
    */
   public static void o(Z1 z, int w, int d) {

      int n = z.n;

      int ww = w + d + 10;
      int ncp = (Parameters.PageWidth) / ww;

      int jl = 0;
      while (jl < n) {
         int ju = Math.min(n, jl + ncp);

         System.out.print("\n");

         String head = "";

         for (int j = jl; j < ju; j++) {
            head = Integer.toString(j);
            while (head.length() < ww) {
               head = " " + head;
            }
            System.out.print(head);
         }
         System.out.print("\n");

         for (int j = jl; j < ju; j++) {
            System.out.print(ZtoEstring(new Z(z.re[j], z.im[j]), w, d));
         }
         System.out.print("\n");
         jl = jl + ncp;
      }
   }

   /**
    * Prints a Zmat in default e format.
    *
    * @param A the Zmat
    */
   public static void o(Zmat A) {
      o(A, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints a Zmat in w.d e format.This method checks to see if the Zmat is real, in which case it prints only the real part.
    *
    * @param A the Zmat
    * @param w the w
    * @param d the d
    */
   public static void o(Zmat A, int w, int d) {

      int nr = A.nrow;
      int nc = A.ncol;
      A.getProperties();


      /*    Check to see if the matrix is real. */
      boolean real = true;
      real:
      for (int i = A.bx; i <= A.rx; i++) {
         for (int j = A.bx; j <= A.cx; j++) {
            if (A.im[i - A.bx][j - A.bx] != 0.) {
               real = false;
               break real;
            }
         }
      }

      if (!real) {

         String temp = Integer.toString(nr + A.bx - 1);
         int rfw = temp.length() + 1;

         int ww = w + d + 10;
         int ncp = (Parameters.PageWidth - rfw) / ww;

         int jl = 0;
         while (jl < nc) {
            int ju = Math.min(nc, jl + ncp);

            System.out.print("\n");

            String head = "";
            while (head.length() < rfw) {
               head = head + " ";
            }
            System.out.print(head);

            for (int j = jl; j < ju; j++) {
               head = Integer.toString(j + A.bx);
               while (head.length() < ww) {
                  head = " " + head;
               }
               System.out.print(head);
            }
            System.out.print("\n");

            for (int i = 0; i < nr; i++) {
               String row = Integer.toString(i + A.bx);
               while (row.length() < rfw) {
                  row = " " + row;
               }
               System.out.print(row);
               for (int j = jl; j < ju; j++) {
                  String snum = DoubletoEstring(A.re[i][j], w, d);
                  if (A.im[i][j] < 0) {
                     snum = snum + " - "
                        + DoubletoEstring(-A.im[i][j], d + 6, d) + "i";
                  } else {
                     snum = snum + " + "
                        + DoubletoEstring(A.im[i][j], d + 6, d) + "i";
                  }
                  System.out.print(snum);
               }
               System.out.print("\n");
            }
            jl = jl + ncp;
         }
      } else {

         String temp = Integer.toString(A.rx);
         int rfw = temp.length() + 1;

         int ncp = (Parameters.PageWidth - rfw) / w;

         int jl = A.bx;
         while (jl <= A.cx) {
            int ju = Math.min(A.cx, jl + ncp - 1);

            System.out.print("\n");

            String head = "";
            while (head.length() < rfw) {
               head = head + " ";
            }
            System.out.print(head);

            for (int j = jl; j <= ju; j++) {
               head = Integer.toString(j);
               while (head.length() < w) {
                  head = " " + head;
               }
               System.out.print(head);
            }
            System.out.print("\n");

            for (int i = A.bx; i <= A.rx; i++) {
               String row = Integer.toString(i);
               while (row.length() < rfw) {
                  row = " " + row;
               }
               System.out.print(row);
               for (int j = jl; j <= ju; j++) {
                  System.out.print(DoubletoEstring(A.re[i - A.bx][j - A.bx], w, d));
               }
               System.out.print("\n");
            }
            jl = jl + ncp;
         }
      }
   }

   /**
    * Prints a Zdiagmat in default format.
    *
    * @param D the Zdiagmat
    */
   public static void o(Zdiagmat D) {
      o(D, Parameters.OutputFieldWidth, Parameters.OutputFracPlaces);
   }

   /**
    * Prints a Zdiagmat in w.d e format.
    *
    * @param D the Zdiagmat
    * @param w the w
    * @param d the d
    */
   public static void o(Zdiagmat D, int w, int d) {

      int n = D.order;

      int ww = w + d + 10;
      int ncp = (Parameters.PageWidth) / ww;

      int jl = 0;
      while (jl < n) {
         int ju = Math.min(n, jl + ncp);

         System.out.print("\n");

         String head = "";

         for (int j = jl; j < ju; j++) {
            head = Integer.toString(j + D.bx);
            while (head.length() < ww) {
               head = " " + head;
            }
            System.out.print(head);
         }
         System.out.print("\n");

         for (int j = jl; j < ju; j++) {
            System.out.print(ZtoEstring(new Z(D.re[j], D.im[j]), w, d));
         }
         System.out.print("\n");
         jl = jl + ncp;
      }
   }

   /**
    * Converts a double to w.d e format.
    *
    * @param num the double
    * @param w the w
    * @param d the d
    * @return the String
    */
   public static String DoubletoEstring(double num, int w, int d) {
      boolean minusf = false;
      boolean minuse = false;
      String snum;

      if (Double.isNaN(num)) {
         snum = "NaN";
      } else if (Double.isInfinite(num)) {
         snum = "Infty";
      } else if (num == 0.0) {
         snum = "e+00";
         for (int i = 0; i < d; i++) {
            snum = "0" + snum;
         }
         snum = "0." + snum;
      } else {
         if (num < 0) {
            minusf = true;
            num = -num;
         }

         int exp = (int) (Math.log(num) / Math.log(10.0));
         if (num < 1) {
            exp = exp - 1;
         }
         double frac = num / Math.pow(10, exp);

         if (frac > 10. - Math.pow(10., -d)) {
            frac = frac / 10;
            exp = exp + 1;
         }

         fmt.setMaximumFractionDigits(d);
         fmt.setMinimumFractionDigits(d);
         fmt.setGroupingUsed(false);
         String sfrac = fmt.format(frac);

         if (exp < 0) {
            minuse = true;
            exp = -exp;
         }

         String sexp = Integer.toString(exp);

         snum = sexp;
         if (snum.length() < 2) {
            snum = "0" + snum;
         }
         if (minuse) {
            snum = "e-" + snum;
         } else {
            snum = "e+" + snum;
         }
         snum = sfrac + snum;
         if (minusf) {
            snum = "-" + snum;
         }
      }
      while (snum.length() < w) {
         snum = " " + snum;
      }
      return snum;
   }

   /**
    * Converts a Z to w.d e format.
    *
    * @param num the double
    * @param w the w
    * @param d the d
    * @return the String
    */
   public static String ZtoEstring(Z num, int w, int d) {

      String snum = DoubletoEstring(num.re, w, d);
      if (num.im < 0) {
         snum = snum + " - "
            + DoubletoEstring(-num.im, d + 6, d) + "i";
      } else {
         snum = snum + " + "
            + DoubletoEstring(num.im, d + 6, d) + "i";
      }
      return snum;
   }
}
