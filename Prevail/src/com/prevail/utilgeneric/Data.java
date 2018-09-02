package com.prevail.utilgeneric;

import org.testng.annotations.DataProvider;
import org.testng.xml.XmlTest;

public class Data {
	
	@DataProvider()
	public Object[][] loginVal()
	{
		return new Object[][] {{"",""},{"test@revcom",""},{"testrev.com",""},{"testi@yaho.com","test"}};
	}
	
	@DataProvider
	public Object[][] register() {
	    return new Object[][] {
	            { new TestData("  "," "," "," "," "," ") },
	            { new TestData("Morethan50CharactersMorethan50CharactersMorethan50CharactersMorethan50Characters","Morethan50CharactersMorethan50CharactersMorethan50CharactersMorethan50Characters","Morethan50CharactersMorethan50CharactersMorethan50CharactersMorethan50Characters","Morethan50CharactersMorethan50CharactersMorethan50CharactersMorethan50Characters","Morethan8CharactersMorethan8Characters","Morethan8CharactersMorethan8Characters") },
	            { new TestData("#$$%^&$","#$$%^&$","#$$%^&$","#$$%^&$","#$$%^&$","#$$%^&$") },
	            { new TestData("1234#$$%%$","1234#$$%%$","1234#$$%%$","1234#$$%%$","1234#$$%%$","1234#$$%%$") },
	            { new TestData("123344566","123344566","123344566","123344566","123344566","123344566") },
	            { new TestData("Prevail","Test","PrevailTest@gmail.com","PrevailTest@gmail.com","Pass@12345","Pass@12345") },
	    };
	}
	
	@DataProvider
	public static Object[][] AddressDataValidation() {
		return new Object[][] {
				//Blank-0
				{ new TestData(" "," "," "," "," "," ","Select..."," "," ") },
				//special characters-1
				{ new TestData("!@#$%^&*()",")(*&^%$#@","$#@&^%)(*","(*)^%&$#@","!@#$%^&*()","!@#$%^&*()","Tennessee","!@#$%^&*()","!@#$%^&*()") },
				//Alphanumeric characters-2
				{ new TestData("1aj23at4","1aj23at4","1aj23at4","1aj23at4","1aj23at4","1aj23at4","Tennessee","1aj23at4","1aj23at4") },
				//Numbers-3
				{ new TestData("23123","12313","123123","12321","13221","123123","Tennessee","8732","623864") },
				//More than 50-4
				{ new TestData("MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","Tennessee","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar") },		
				//Single character-5
				{ new TestData("a","b","c","d","e","f","Tennessee","h","i") },
				//Existing address - 6
				{ new TestData("Address2","Shashidhar","Marihal","261 dennis st"," ","Athens","Tennessee","37302","3333333333") },
		};
	}
	
	
	@DataProvider
	public static Object[][] PaymentValidations() {
		return new Object[][] {
				//Blank
				{ new TestData(" ","Visa"," ","January","2018"," "," "," "," ","United States","Select..."," "," "," "," ") },
				//special characters
				{ new TestData("#####$%#$%#$#%%#$","Visa","#####$%#$%#$#%%#$","January","2018","#####$%#$%#$#%%#$","#####$%#$%#$#%%#$","#####$%#$%#$#%%#$","#####$%#$%#$#%%#$","United States","Select...","#####$%#$%#$#%%#$","#####$%#$%#$#%%#$","#####$%#$%#$#%%#$","#####$%#$%#$#%%#$") },
				//Alphanumeric characters
				{ new TestData("!as3 #$%^) ","Visa","!as3 #$%^) ","January","2018","!as3 #$%^) ","!as3 #$%^) ","!as3 #$%^) ","!as3 #$%^) ","United States","Select...","!as3 #$%^) ","!as3 #$%^) ","!as3 #$%^) ","!as3 #$%^) ") },
				//Numbers
				{ new TestData("11223455643","Visa","11223455643","January","2018","1122345564311223455643","11223455643","11223455643","United States","Select...","11223455643","11223455643","11223455643","11223455643") },
				//More than 50
				{ new TestData("MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar",
						"Visa",
						"411111111111111111111115657",
						"January",
						"2018",
						"MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar",
						"MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar",
						"MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar",
						"MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar",
						"United States",
						"Select...",
						"MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar",
						"MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar",
						"MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar",
						"MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar") },		
		};
	}
	
	@DataProvider
	public static Object[][] Find_Wishlist_Validation() throws Exception {
		int rowNum=new Integer(BaseTest.xmlTest.getParameter("dynamicNum"));
		return new Object[][] {
				//Blank spaces-0
				{ new TestData(" "," "," ") },
				//Empty-1
				{ new TestData("","","") },
				//special characters-2
				{ new TestData("!@#$%^&*()",")(*&^%$#@","$#@&^%)(*") },
				//Alphanumeric characters-3
				{ new TestData("1aj23at4","1aj23at4","1aj23at4.com") },
				//Numbers-4
				{ new TestData("23123","12313","123@com") },
				//More than 50-5
				{ new TestData("MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar") },
				//Valid-6
				{ new TestData(GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,1),GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,0),GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,2)) },
		};
	}
	
	@DataProvider
	public static Object[][] Find_Wishlist_Reg_Validation() throws Exception {
		int rowNum=new Integer(BaseTest.xmlTest.getParameter("dynamicNum"));
		return new Object[][] {
				//Blank spaces-0
				{ new TestData(" "," "," ") },
				//Empty-1
				{ new TestData("","","") },
				//special characters-2
				{ new TestData("!@#$%^&*()",")(*&^%$#@","$#@&^%)(*") },
				//Alphanumeric characters-3
				{ new TestData("1aj23at4","1aj23at4","1aj23at4.com") },
				//Numbers-4
				{ new TestData("23123","12313","123@com") },
				//More than 50-5
				{ new TestData("MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar") },		
				//Valid With No wishlist products-6
				{ new TestData("Marihal","Shashidhar","NowishlistProducts@gmail.com") },
				//Valid-7
				{ new TestData(GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,1),GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,0),GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,2)) },
		};
	}
	
	@DataProvider
	public static Object[][] Wishlist_Login_Validation() throws Exception {
		int rowNum=new Integer(BaseTest.xmlTest.getParameter("dynamicNum"));
		return new Object[][] {
				//Blank spaces-0
				{ new TestData(" "," ") },
				//<8 -1
				{ new TestData("asdfa","asddw") },
				//Without .-2
				{ new TestData("Shashidhar@gmailcom","India@123") },
				//Without @-3
				{ new TestData("Shashidhargmail.com","India@123") },
				//Non Matching Email and pwd-4
				{ new TestData("Shashidhar@gmail.com","ndia@212124") },		
				//Valid-5
				{ new TestData(GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,0),GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,1)) },
		};
	}
	@DataProvider
	public static Object[][] Wishlist_Quantity_Validation() {
		return new Object[][] {
				//Alphabets
				{ new TestData("ab") },
				//Spl characters
				{ new TestData("@$%") },
				//Alphanumeric 
				{ new TestData("1#3") },		
				//Valid
				{ new TestData("2") },		
		};
	}


	@DataProvider
	public static Object[][] EditAccount_PasswordFieldValidation() {
		return new Object[][] {
				{ new TestData(" "," "," ") },
				{ new TestData(">than8",">than8",">than8") },
				{ new TestData("Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters"
						+ "Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters"
						+ "Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters"
						,"Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters"
						+ "Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters"
						+ "Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters"
						,"Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters"
						+ "Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters"
						+ "Morethan255charactersMorethan255charactersMorethan255charactersMorethan255charactersMorethan255characters") },
		};	
	}
	
	
	@DataProvider
	public static Object[][] ValidShippingAddress () {
		return new Object[][] {
				//Blank
				{ new TestData("John","Carol","2550 McMillan Parkway","POBox 37","Fort Worth","76137","United States","Texas","3333333333") },
		};
	}
	
	@DataProvider
	public static Object[][] ValidBillingAddress () {
		return new Object[][] {
				//Blank
				{ new TestData("John","Carol","2550 McMillan Parkway","POBox 37","Fort Worth","76137","United States","Texas","3333333333") },
		};
	}
	@DataProvider
	public static Object[][] LoginEmailValidation(){
		return new Object[][]{
			//Enter less than 6 characters in email address
				{new TestData("R@c.c")},
			//email address with out . symbol	
				{new TestData("R@cc")},
		   //email address with out @ symbol 
				{new TestData("Rcc")},
			//Leave the email address field empty,
				{new TestData(" ")},
			//white spaces at the start of characters of the email address
				{new TestData("V inaylanka@gmail.com")},	
		    //white spaces in between characters of the Email address 
				{new TestData("V i n a y lanka@gmail.com")},
			//Enter only numeric value in email address field
				{new TestData("1234@12.879")},
			// Enter only Special characters in email address field	
				{new TestData("!@#$%^&*()")},
			// only alphabets in email address field
				{new TestData("TestData")},
			//Enter valid non registered email address in	
				{new TestData("MS@gmail.com")},
			//Enter more than 50 Character
				{new TestData("MSMSCVVCMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSHAKIDJU@gmail.com")},
			//Enter Valid email id
				{new TestData("Vinaylanka@gmail.com")},
		};
	}
	
	@DataProvider
	public static Object[][] OrderEmailIdvalidation(){
		return new Object[][]{
			//Enter less than 6 characters in email address
				{new TestData("R@c.c")},
			//email address with out . symbol	
				{new TestData("R@cc")},
		   //email address with out @ symbol 
				{new TestData("Rcc")},
			//Leave the email address field empty,
				{new TestData(" ")},
			//white spaces at the start of characters of the email address
				{new TestData("V inaylanka@gmail.com")},	
		    //white spaces in between characters of the Email address 
				{new TestData("V i n a y lanka@gmail.com")},
			//Enter only numeric value in email address field
				{new TestData("1234@12.879")},
			// Enter only Special characters in email address field	
				{new TestData("!@#$%^&*()")},
			// only alphabets in email address field
				{new TestData("TestData")},
			//Enter valid non registered email address in	
				{new TestData("MS@gmail.com")},
			//Enter more than 50 Character
				{new TestData("MSMSCVVCMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSMSHAKIDJU@gmail.com")},
			//Enter Valid email id
				{new TestData("Vinaylanka@gmail.com")},
			
		};
	}
	
	
	@DataProvider
	public static Object[][] OrderIdvalidation(){
		return new Object[][]{
		// Enter invalid order number.
				{new TestData("PRV000772052345")},		
		//Leave the 'Order number' field empty		
				{new TestData(" ")},
		//Enter max number of characters		
				{new TestData("PRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevailPRevail123")},
				
		//Enter only numeric value
				{new TestData("123456")},	
		//Enter Valid order number	
				{new TestData("PRV00077205")},	
				
	};
	
}
	
	@DataProvider
	public static Object[][] PasswordIdvalidation(){
		return new Object[][]{
				// Enter invalid Password.
				{new TestData("Revtech")},			
				//Less than 8 characters
				{new TestData("Rev")},		
				//Empty field
				{new TestData("")},	
				//More than 8 characters
				{new TestData("RevRevRevRevRevRevRev")},	
				//Valid
				{new TestData("	Vin@74113")},	
		};
		}
	
	
	@DataProvider
	public static Object[][] ZipCodevalidation(){
		return new Object[][]{
				
				//less than 5 
				{new TestData("123")},		
			    //only alphabets in
				{new TestData("aaa")},
				//more than 5 character
				{new TestData("6070763")},
				 //onlySpecial Characters in
				{new TestData("#@$%")},
				// alphanumeric characters
				{new TestData("12SD")},
				//spaces
				{new TestData("   ")},
				//empty field
				{new TestData("")},
				//invalid zipcode
				{new TestData("60709")},
				//valid
				{new TestData("60707")},
		};
	}
	
	@DataProvider
	public static Object[][] IntermediateLoginValidations(){
		return new Object[][]{
				
				//less than 5 
				{new TestData("123")},		
			    //only alphabets in
				{new TestData("aaa")},
				//more than 5 character
				{new TestData("6070763")},
				 //onlySpecial Characters in
				{new TestData("#@$%")},
				// alphanumeric characters
				{new TestData("12SD")},
				//spaces
				{new TestData("   ")},
				//empty field
				{new TestData("")},
				//invalid zipcode
				{new TestData("60709")},
				//valid
				{new TestData("60707")},
		};
	}
	
	@DataProvider
	public static Object[][] ShippingValidations(){
		return new Object[][]{
				
				//Blank Data
				{new TestData(" "," "," "," "," "," "," ","United States","Select..."," ")},		
				//Enter more than 50 characters
				{new TestData("EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "United States",
							  "Alaska",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters")},
				//
				{new TestData("!!@##$%%#@!!!!",
							  "@@#$%%%%%@#$%%",
							  "@@#$%%%%%@#$%%",
							  "@@#$%%%%%@#$%%",
							  "@@#$%%%%%@#$%%",
							  "@@#$%%%%%@#$%%",
							  "United States",
							  "Alaska",
							  "!!@##$%%#@!!!!")},
				 //
				{new TestData("12334567678",
						      "12334567678",
						      "12334567678",
						      "12334567678",
						      "12334567678",
						      "12334567678",
						      "United States",
							  "Alaska",
						      "12334567678"
						      )},
				//
				{new TestData("12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
						      "United States",
							  "Alaska",
						      "12 AD ad #$% ER%")},
						      
			  	{new TestData("Vinay",
						  "Lanka",
						  "77 Massachusetts Avenue",
						  "Cambridge",
						  "Boston",
						  "12 AD ad #$% ER%",
					      "United States",
						  "Alaska",
					      "12 AD ad #$% ER%")},

		};
	}
	
	@DataProvider
	public static Object[][] MPCShippingValidations() {
		return new Object[][] {
				//Blank-0
				{ new TestData(" "," "," "," "," ","Select..."," "," ") },
				//Cancel-1
				{ new TestData(" "," "," "," "," ","Select..."," "," ") },
				//special characters-2
				{ new TestData(")(*&^%$#@","$#@&^%)(*","(*)^%&$#@","!@#$%^&*()","!@#$%^&*()","Tennessee","!@#$%^&*()","!@#$%^&*()") },
				//Alphanumeric characters-3
				{ new TestData("1aj23at4","1aj23at4","1aj23at4","1aj23at4","1aj23at4","Tennessee","1aj23at4","1aj23at4") },
				//Numbers-4
				{ new TestData("12313","123123","12321","13221","123123","Tennessee","8732","623864") },
				//More than 50-5
				{ new TestData("MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","Tennessee","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar","MorethandadasdsadCharactersMorethanCharactersMorethanCharactersMorethanChar") },		
				//Esc key - 6
				{ new TestData("Shashidhar","Marihal","261 dennis st"," ","Athens","Tennessee","37302","3333333333") },
				//Valid address - 7
				{ new TestData("Shashidhar","Marihal","261 dennis st"," ","Athens","Tennessee","37302","3333333333") },
		};
	}
	
	@DataProvider
	public static Object[][] BillingValidations(){
		return new Object[][]{
				
				//Blank Data
				{new TestData(" "," "," "," "," "," "," ","United States","Select..."," ")},		
				//Enter more than 50 characters
				{new TestData("EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters",
							  "United States",
							  "Select...",
							  "EnterMoreThan50CharactersEnterMoreThan50CharactersEnterMoreThan50Characters")},
				//
				{new TestData("!!@##$%%#@!!!!",
							  "@@#$%%%%%@#$%%",
							  "@@#$%%%%%@#$%%",
							  "@@#$%%%%%@#$%%",
							  "@@#$%%%%%@#$%%",
							  "@@#$%%%%%@#$%%",
							  "United States",
							  "Select...",
							  "!!@##$%%#@!!!!")},
				 //
				{new TestData("12334567678",
						      "12334567678",
						      "12334567678",
						      "12334567678",
						      "12334567678",
						      "12334567678",
						      "United States",
							  "Select...",
						      "12334567678"
						      )},
				//
				{new TestData("12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
							  "12 AD ad #$% ER%",
						      "United States",
							  "Select...",
						      "12 AD ad #$% ER%")},
	
		};
	}
	
	@DataProvider
	public static Object[][] ShippingGiftoptionsValidations(){
		return new Object[][]{
				
				{new TestData("EnterTenCh")},
				
		};
	}
	
	@DataProvider
	public static Object[][] StoreZipCodevalidation(){
		return new Object[][]{
				
				//less than 5 
				{new TestData("123")},		
			    //only alphabets in
				{new TestData("aaa")},
				//more than 5 character
				{new TestData("6070763")},
				 //onlySpecial Characters in
				{new TestData("#@$%")},
				// alphanumeric characters
				{new TestData("12SD")},
				//spaces
				{new TestData("   ")},
				//empty field
				{new TestData("")},
				//invalid zipcode
				{new TestData("60709")},
				//valid
				{new TestData("60707")},
		};
	}
	
	@DataProvider
	public static Object[][] QTYvalidation(){
		return new Object[][]{
				
				
				//Special characters
				{new TestData("@#&")},		
				//Alphabets characters
				{new TestData("ABC")},	
				//out off stock
				{new TestData("999")},
				//valid number
				{new TestData("6")},
				
		};
	}
		
	
}

