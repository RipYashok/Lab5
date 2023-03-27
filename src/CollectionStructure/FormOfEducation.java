package CollectionStructure;

public enum FormOfEducation {
    DISTANCE_EDUCATION{
        @Override
        public String toString() { return "Distance education";}
    },
    FULL_TIME_EDUCATION{
        @Override
        public String toString() { return "Full time education";}
    },
    EVENING_CLASSES{
        @Override
        public String toString() { return "Evening classes";};
    };
}
