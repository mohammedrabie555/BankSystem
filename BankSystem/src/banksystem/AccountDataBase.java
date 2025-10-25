package banksystem;

import java.util.ArrayList;

public class AccountDataBase {
    ArrayList<SavingAccountLocal>savingLocal = new ArrayList<>();
    ArrayList<SavingAccountForeign>savingForeign = new ArrayList<>();
    ArrayList<CurrentAccountLocal>currentLocal = new ArrayList<>();
    ArrayList<CurrentAccountForeign>currentForeign= new ArrayList<>();
}
