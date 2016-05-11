package pranjal.complexlistview;

public class GOT {
    private String Name;
    private String Description;
    private int Date;
    private int iconID;

    public GOT (String Name, String Description, int Date, int iconID){
        this.Name = Name;
        this.Description = Description;
        this.Date = Date;
        this.iconID = iconID;
    }

    public String getName(){
        return Name;
    }

    public String getDescription(){
        return Description;
    }

    public int getDate(){
        return Date;
    }

    public int getIconID(){
        return iconID;
    }

}
