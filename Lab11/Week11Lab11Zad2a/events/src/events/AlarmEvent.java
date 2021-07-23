package events;

public class AlarmEvent {
        private int nrings;

        public AlarmEvent(int nrings) {
            setNrings(nrings);
        }

        public int getNrings() {
            return nrings;
        }

        public void setNrings(int nrings) {
            this.nrings = nrings >= 0 ? nrings : 0;
        }
    }

