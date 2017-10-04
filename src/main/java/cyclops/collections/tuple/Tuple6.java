package cyclops.collections.tuple;


import com.aol.cyclops2.types.foldable.To;
import cyclops.function.Fn3;
import cyclops.function.Fn5;
import cyclops.function.Fn6;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.function.Function;
import java.util.function.Supplier;

/*
  A Tuple implementation that can be either eager / strict or lazy


 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Tuple6<T1,T2,T3,T4,T5,T6> implements To<Tuple6<T1,T2,T3,T4,T5,T6>>,
                                                Serializable{

    private static final long serialVersionUID = 1L;

    public static <T1,T2,T3,T4,T5,T6> Tuple6<T1,T2,T3,T4,T5,T6> of(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5, T6 value6) {
        return new Tuple6<>(value1,value2,value3,value4,value5,value6);
    }
    public static <T1,T2,T3,T4,T5, T6> Tuple6<T1,T2,T3,T4,T5,T6> lazy(Supplier<? extends T1> supplier1,
                                                               Supplier<? extends T2> supplier2,
                                                               Supplier<? extends T3> supplier3,
                                                               Supplier<? extends T4> supplier4,
                                                               Supplier<? extends T5> supplier5,
                                                                      Supplier<? extends T6> supplier6) {
        return new Tuple6<T1,T2,T3,T4,T5,T6>(null,null,null,null,null, null) {
            @Override
            public T1 _1() {
                return supplier1.get();
            }
            @Override
            public T2 _2() {
                return supplier2.get();
            }

            @Override
            public T3 _3() {
                return supplier3.get();
            }

            @Override
            public T4 _4() {
                return supplier4.get();
            }

            @Override
            public T5 _5() {
                return supplier5.get();
            }

            @Override
            public T6 _6() {
                return supplier6.get();
            }
        };
    }
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;
    private final T5 _5;
    private final T6 _6;

    public T1 _1(){
        return _1;
    }
    public  T2 _2(){
        return _2;
    }
    public  T3 _3(){
        return _3;
    }
    public  T4 _4(){
        return _4;
    }
    public  T5 _5(){
        return _5;
    }
    public  T6 _6(){
        return _6;
    }

    public Tuple1<T1> first(){
        return Tuple.tuple(_1());
    }

    public Tuple1<T2> second(){
        return Tuple.tuple(_2());
    }

    public Tuple1<T3> third(){
        return Tuple.tuple(_3());
    }

    public Tuple1<T4> fourth(){
        return Tuple.tuple(_4());
    }

    public Tuple1<T5> fifth(){
        return Tuple.tuple(_5());
    }

    public Tuple1<T6> sixth(){
        return Tuple.tuple(_6());
    }

    public Tuple6<T1,T2,T3,T4,T5,T6> eager(){
        return of(_1(),_2(),_3(),_4(),_5(),_6());
    }


    public <R1,R2,R3,R4,R5,R6> Tuple6<R1,R2,R3,R4,R5,R6> mapAll(Function<? super T1, ? extends R1> fn1, Function<? super T2,? extends R2> fn2,
                                                            Function<? super T3,? extends R3> fn3,
                                                            Function<? super T4,? extends R4> fn4,
                                                            Function<? super T5,? extends R5> fn5,
                                                                  Function<? super T6,? extends R6> fn6){
        return of( fn1.apply(_1()),
                    fn2.apply(_2()),
                    fn3.apply(_3()),
                    fn4.apply(_4()),
                    fn5.apply(_5()),
                    fn6.apply(_6()));
    }

    public <R1,R2,R3,R4,R5,R6> Tuple6<R1,R2,R3,R4,R5,R6> lazyMapAll(Function<? super T1, ? extends R1> fn1, Function<? super T2,? extends R2> fn2,
                                                              Function<? super T3,? extends R3> fn3,
                                                              Function<? super T4,? extends R4> fn4,
                                                              Function<? super T5,? extends R5> fn5,
                                                                      Function<? super T6,? extends R6> fn6){
        return lazy(()->(fn1.apply(_1())),()->fn2.apply(_2()),()->fn3.apply(_3()),()->fn4.apply(_4()),
                ()->fn5.apply(_5()),()->fn6.apply(_6()));
    }
    public <R> Tuple6<R, T2,T3,T4,T5,T6> map1(Function<? super T1, ? extends R> fn) {
        return of(fn.apply(_1()), _2(),_3(),_4(),_5(),_6());
    }
    public <R> Tuple6<R, T2,T3,T4,T5,T6> lazyMap1(Function<? super T1, ? extends R> fn) {
        return lazy(()->fn.apply(_1()),()-> _2(),()->_3(),()->_4(),()->_5(),()->_6());
    }
    public <R> Tuple6<T1, R, T3, T4,T5,T6> map2(Function<? super T2, ? extends R> fn) {
        return of(_1(), fn.apply(_2()),_3(),_4(),_5(),_6());
    }
    public <R> Tuple6<T1, R, T3,T4,T5,T6> lazyMap2(Function<? super T2, ? extends R> fn) {
        return lazy(() -> _1(), () -> fn.apply(_2()),()->_3(),()->_4(),()->_5(),()->_6());
    }
    public <R> Tuple6<T1, T2, R,T4,T5,T6> map3(Function<? super T3, ? extends R> fn) {
        return of(_1(), _2(),fn.apply(_3()),_4(),_5(),_6());
    }
    public <R> Tuple6<T1, T2, R,T4,T5,T6> lazyMap3(Function<? super T3, ? extends R> fn) {
        return lazy(() -> _1(), () -> _2(),()->fn.apply(_3()),()->_4(),()->_5(),()->_6());
    }
    public <R> Tuple6<T1, T2, T3, R , T5, T6> map4(Function<? super T4, ? extends R> fn) {
        return of(_1(), _2(),_3(),fn.apply(_4()),_5(),_6());
    }
    public <R> Tuple6<T1, T2, T3, R, T5,T6> lazyMap4(Function<? super T4, ? extends R> fn) {
        return lazy(() -> _1(), () -> _2(),()->_3(),()->fn.apply(_4()),()->_5(),()->_6());
    }
    public <R> Tuple6<T1, T2, T3, T4 , R,T6> map5(Function<? super T5, ? extends R> fn) {
        return of(_1(), _2(),_3(),_4(),fn.apply(_5()),_6());
    }
    public <R> Tuple6<T1, T2, T3, T4, R,T6> lazyMap5(Function<? super T5, ? extends R> fn) {
        return lazy(() -> _1(), () -> _2(),()->_3(),()->_4(),()->fn.apply(_5()),()->_6());
    }

    public <R> Tuple6<T1, T2, T3, T4 , T5,R> map6(Function<? super T6, ? extends R> fn) {
        return of(_1(), _2(),_3(),_4(),_5(),fn.apply(_6()));
    }
    public <R> Tuple6<T1, T2, T3, T4, T5,R> lazyMap6(Function<? super T6, ? extends R> fn) {
        return lazy(() -> _1(), () -> _2(),()->_3(),()->_4(),()->_5(),()->fn.apply(_6()));
    }

    public <R> R visit(Fn6<? super T1, ? super T2, ? super T3,? super T4, ? super T5,? super T6,? extends R> fn){
        return fn.apply(_1(),_2(),_3(),_4(),_5(),_6());
    }

    @Override
    public String toString() {
        return String.format("[%s,%s,%s,%s,%s,%s]", _1(),_2(),_3(),_4(),_5(),_6());
    }




}