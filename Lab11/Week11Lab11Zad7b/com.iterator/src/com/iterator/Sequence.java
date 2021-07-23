package com.iterator;

public class Sequence { // outer class
    // Holds a sequence of Objects.
    private Object[] obs;
    private int next = 0;

    public Sequence(int size) {
        obs = new Object[size];
    }

    public void add(Object x) {
        if (next < obs.length) {
            obs[next] = x;
            next++;
        }
    }

    private class SSelectorForward implements SelectorForward {
        // inner class манипулира преместване от първия към последния
        int i = 0;

        @Override
        public boolean end() {
            return i == obs.length;
        }

        @Override
        public Object current() {
            return obs[i];
        }

        @Override
        public void next() {
            if (i < obs.length) i++;
        }
    }

    private class SSelectorBackward implements SelectorBackward {
        // inner class манипулира преместване от последния към първия
        int i = obs.length - 1;

        @Override
        public boolean begin() {
            return i < 0;
        }

        @Override
        public Object current() {
            return obs[i];
        }

        @Override
        public void previous() {
            if (i >= 0) i--;
        }
    }

    private class SSelectorTwoWay implements SelectorTwoWay {

        private int i;

        public SSelectorTwoWay(int index) {
            setI(index);
        }

        public void setI(int i) {
            this.i = i >= 0 && i < obs.length ? i : 0;
        }

        @Override
        public boolean end() {
            return i == obs.length - 1;
        }

        @Override
        public Object current() {
            return obs[i];
        }

        @Override
        public void next() {
            if (i < obs.length) i++;
        }

        @Override
        public boolean begin() {
            return i < 0;
        }

        @Override
        public void previous() {
            if (i >= 0) i--;
        }
    }

    public SelectorForward getSelectorForward() {
        return new SSelectorForward();
    }

    public SelectorBackward getSelectorBackward() {
        return new SSelectorBackward();
    }

    public SelectorTwoWay getSelectorTwoWay() {
        return new SSelectorTwoWay(0);
    }
}
