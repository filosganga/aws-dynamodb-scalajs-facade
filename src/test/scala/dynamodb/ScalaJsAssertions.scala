package com.filippodeluca.jsfacade.aws
package dynamodb

import cats.syntax.all._

import scalajs.js

trait ScalaJsAssertions {
  self: munit.Suite =>

  implicit def compareForJsDictionary[A, B](implicit
      compare: munit.Compare[A, B]
  ): munit.Compare[js.Dictionary[A], js.Dictionary[B]] =
    new munit.Compare[js.Dictionary[A], js.Dictionary[B]] {
      def isEqual(
          obtained: js.Dictionary[A],
          expected: js.Dictionary[B]
      ): Boolean = {
        if (obtained.size != expected.size) {
          false
        } else {
          expected.foldLeft(true) { case (acc, (key, b)) =>
            acc && obtained
              .get(key)
              .map { a =>
                compare.isEqual(a, b)
              }
              .getOrElse(false)
          }
        }
      }
    }

  implicit lazy val compareForAttributeValue
      : munit.Compare[AttributeValue, AttributeValue] =
    new munit.Compare[AttributeValue, AttributeValue] {
      def isEqual(
          obtained: AttributeValue,
          expected: AttributeValue
      ): Boolean = {
        List(
          (
            obtained.NULL.toOption,
            expected.NULL.toOption
          ).mapN(_ == _),
          (
            obtained.S.toOption,
            expected.S.toOption
          ).mapN(_ == _),
          (
            obtained.N.toOption,
            expected.N.toOption
          ).mapN(_ == _),
          (
            obtained.B.toOption,
            expected.B.toOption
          ).mapN { (a, b) =>
            a.size == b.size && a.zip(b).foldLeft(true) { case (acc, (a, b)) =>
              acc && a == b
            }
          },
          (
            obtained.BOOL.toOption,
            expected.BOOL.toOption
          ).mapN(_ == _),
          (
            obtained.SS.toOption,
            expected.SS.toOption
          ).mapN { (as, bs) =>
            as.toList == bs.toList
          },
          (
            obtained.NS.toOption,
            expected.NS.toOption
          ).mapN { (as, bs) =>
            as.toList == bs.toList
          },
          (
            obtained.BS.toOption,
            expected.BS.toOption
          ).mapN { (as, bs) =>
            as.size == bs.size && as.zip(bs).foldLeft(true) {
              case (acc, (a, b)) =>
                acc && a.size == b.size && a.zip(b).foldLeft(true) {
                  case (acc, (a, b)) =>
                    acc && a == b
                }
            }
          },
          (obtained.L.toOption, expected.L.toOption)
            .mapN { (as, bs) =>
              if (as.size != bs.size) {
                false
              } else {
                as.zip(bs).foldLeft(true) { case (acc, (a, b)) =>
                  acc && compareForAttributeValue.isEqual(a, b)
                }
              }
            },
          (
            obtained.M.toOption,
            expected.M.toOption
          ).mapN { (a, b) =>
            b.foldLeft(false) { case (acc, (key, value)) =>
              acc && a
                .get(key)
                .exists(a => compareForAttributeValue.isEqual(a, value))
            }
          }
        ).reduce(_ orElse _).getOrElse(false)
      }
    }

  implicit def compareForSet[A](implicit
      compare: munit.Compare[A, A]
  ): munit.Compare[Set[A], Set[A]] = new munit.Compare[Set[A], Set[A]] {
    def isEqual(obtained: Set[A], expected: Set[A]): Boolean = {
      if (expected.size != obtained.size) {
        false
      } else {
        expected.foldLeft(true) { (acc, b) =>
          acc && obtained.exists(a => compare.isEqual(a, b))
        }
      }
    }
  }

}
