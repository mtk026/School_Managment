package Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {

	public static void optionPaneChangeButtonTExt() {
		UIManager.put("OptionPane.cancelButtonText","İptal");
		UIManager.put("OptionPane.noButtonText","İptal");
		UIManager.put("OptionPane.okButtonText","tamam");
		UIManager.put("OptionPane.yesButtonText","Evet");
		
	}
	
	
	
	
	public static void showMessage(String str) {
		String msg;
		optionPaneChangeButtonTExt();
		switch(str) {
		case "fill":
         msg="LÜTFEN TÜM ALANLARI DOLDURUNUZ"	;
         break;
		case"success":
			
		 msg ="İŞLEM BAŞARILI";
		 break;
		
		
         default : msg=str;
		
		}
		JOptionPane.showMessageDialog(null,msg,"MESAJ",JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static boolean confirm(String str) {
		String msg;
		optionPaneChangeButtonTExt();
		switch (str) {
		
		case "sure":
			msg="BU İŞLEMİ YAPMAK İSTİYOR MUSUN?";
			break;
			default :
			msg=str;
			break;
	}
			int result = JOptionPane.showConfirmDialog((null), msg,"DİKKAT!", JOptionPane.YES_NO_OPTION);
				if(result==0) {
					return true;
				}else {return false;}
	}
	
}
