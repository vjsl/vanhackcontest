package vjsl.cin.ufpe.br.wafercontest.model;

public class RegionalBloc {
    private String acronym;
    private String name;
    private String[] otherAcronyms;
    private String otherNames[];

    public RegionalBloc() {
    }

    public RegionalBloc(String acronym, String name, String[] otherAcronyms, String[] otherNames) {
        this.acronym = acronym;
        this.name = name;
        this.otherAcronyms = otherAcronyms;
        this.otherNames = otherNames;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getOtherAcronyms() {
        return otherAcronyms;
    }

    public void setOtherAcronyms(String[] otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public String[] getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String[] otherNames) {
        this.otherNames = otherNames;
    }
}

