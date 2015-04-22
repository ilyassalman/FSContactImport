package domain;

/**
 * Created by Lukas on 21.04.2015.
 */
public class Organisation {
    private String name;

    public Organisation(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return name.toUpperCase().trim().equals(((Organisation)obj).name.toUpperCase().trim());
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public int hashCode() {
        return name.toUpperCase().trim().hashCode();
    }

    public String getName() {
        return name;
    }
}
