package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.core.Cpu;
import com.app.entities.core.Product;
import com.app.services.accessories.interfaces.ICaseAccessoryService;
import com.app.services.accessories.interfaces.ICaseFanAccessoryService;
import com.app.services.accessories.interfaces.IFanControllerAccessoryService;
import com.app.services.accessories.interfaces.IThermalCompoundAccessoryService;
import com.app.services.accessories.interfaces.IUPSAccessoryService;
import com.app.services.core.interfaces.ICPUService;
import com.app.services.core.interfaces.ICpuCaseService;
import com.app.services.core.interfaces.ICpuCoolerService;
import com.app.services.core.interfaces.IExternalStorageService;
import com.app.services.core.interfaces.IGraphicsCardService;
import com.app.services.core.interfaces.IMonitorService;
import com.app.services.core.interfaces.IMotherboardService;
import com.app.services.core.interfaces.IOperatingSystemService;
import com.app.services.core.interfaces.IOpticalDriveService;
import com.app.services.core.interfaces.IPowerSupplyService;
import com.app.services.core.interfaces.IRAMemoryService;
import com.app.services.core.interfaces.ISoftwareService;
import com.app.services.core.interfaces.IStorageService;
import com.app.services.networking.interfaces.ISoundCardService;
import com.app.services.networking.interfaces.IWiredNetworkAdapterService;
import com.app.services.networking.interfaces.IWirelessNetworkAdapterService;
import com.app.services.peripherals.interfaces.IHeadphonesPeripheralService;
import com.app.services.peripherals.interfaces.IKeyboardPeripheralService;
import com.app.services.peripherals.interfaces.IMicePeripheralService;
import com.app.services.peripherals.interfaces.ISpeakerPeripheralService;
import com.app.services.peripherals.interfaces.IWebcamPeripheralService;
import com.app.utils.ProductConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
     //***************** CORE(13)  ********************* 
	
	//1
	@Autowired
	private ICPUService cpuService;
	
	//2
	@Autowired
	private IRAMemoryService ramService;
	
	//3
	@Autowired
	private IPowerSupplyService powerSupplyService;
	
	//4
	@Autowired
	private ICpuCaseService cpuCaseService;
	
	//5
	@Autowired
	private ICpuCoolerService coolerService;
	
	//6
	@Autowired
	private IGraphicsCardService gpuService;
	
	//7
	@Autowired
	private IMotherboardService motherService;
	
	//8
	@Autowired
	private IMonitorService  monitorService;
	
	//9
	@Autowired
	private IOpticalDriveService opticalDriveService;
	
	//10
	@Autowired
	private IOperatingSystemService  operatingSystemService;
	
	//11
	@Autowired
	private ISoftwareService  softwareService;
	
	//12
	@Autowired
	private IStorageService  storageService;
	
	//13
	@Autowired
	private IExternalStorageService  externalStorageService;
	
	
	
	//************ ACCESSORIES (5) *****************
	
	
	//1
	@Autowired
	private ICaseAccessoryService caseAccService;
	
	
	//2
    @Autowired
	private ICaseFanAccessoryService caseFanAccService;
		
    //3
    @Autowired
	private IFanControllerAccessoryService fanControllerAccService;
    
    //4
    @Autowired
	private IThermalCompoundAccessoryService thermalAccService;
    
    //5
    @Autowired
	private IUPSAccessoryService upsAccService;
		
	//****************** NETWORKING (3) ******************
    
    
    //1
    @Autowired
    private ISoundCardService soundCardService;
    
    //2
    @Autowired
    private IWiredNetworkAdapterService wiredService;
    
    //3
    @Autowired
    private IWirelessNetworkAdapterService wirelessService;
    
	//**************   PERIPHERALS (5) *****************
	
    //1
    @Autowired
    private IHeadphonesPeripheralService headphoneService;
    
    //2
    @Autowired
    private IKeyboardPeripheralService keyboardService;
    
    //3
    @Autowired
    private IMicePeripheralService miceService;
    
    //4
    @Autowired
    private ISpeakerPeripheralService speakerService;
    
    //5
    @Autowired
    private IWebcamPeripheralService webcamService;
    
	
    //############################################    GET ALL PRODUCTS                   ########################################
    
	@GetMapping("/{type}")
	public ResponseEntity<?> showAllProductDetails(@PathVariable String type) {
		
		switch (type) {
		
//*******************************  CORE(13) *******************************************
		case ProductConstants.CORE_CPU:
			                                     System.out.println("in fetch all Cpu Details");
		                                 	try{
		                                 		List<Product> products = cpuService.getAllCpu();
		                                 		 return new ResponseEntity<>(products, HttpStatus.OK);
		                                 	   }
			                    
			                                  catch(Exception e)
			                                  { 
			                                	  // if (products.isEmpty())
				                                   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			                                  } 
			                               

		case ProductConstants.CORE_COOLER:
			                                System.out.println("in fetch all Cpu Cooler Details");
			                                try {
			                                 List<Product> cooler = coolerService.getAllCpuCooler();
			                              // non empty list
			                                 return new ResponseEntity<>(cooler, HttpStatus.OK);
			                                }
		                                    	catch(Exception e) {
		                                    		// chk if empty
		                                    	
			                                   // if (cooler.isEmpty())
				                               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		                                    	}
			                                     
			                                     
		case ProductConstants.CORE_CASE:     System.out.println("in fetch cpu cases products");
		                                          try {
                                                  List<Product> cpuCase = cpuCaseService.getAllCpuCase();
                                                 // non empty list
                                                    return new ResponseEntity<>(cpuCase, HttpStatus.OK);
                                                             }
                                                        	catch(Exception e) {
           		                                       // chk if empty
           	                  
                                                               // if (cooler.isEmpty())
                                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           	                                           }
			                               
		 
		
		
		
		case ProductConstants.CORE_GPU:
			                                  System.out.println("in fetch gpu products");
                                              try {  List<Product> gpu = gpuService.getAllGraphicsCard();
                                             // non empty list
                                                return new ResponseEntity<>(gpu, HttpStatus.OK);
                                              }
                                                 // chk if empty
                                                catch(Exception e) {//if (gpu.isEmpty())
                                             return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
                                        
		case ProductConstants.CORE_MOBO:
			                              System.out.println("in fetch motherboard products");
                                        try { List<Product> motherboard = motherService.getAllMotherboard();
                                         // non empty list
                                         return new ResponseEntity<>(motherboard, HttpStatus.OK);}
                                         
                                          catch(Exception e) 
                                              {// chk if empty
                                        	  //if (motherboard.isEmpty())
                                          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                          }
                                          
		case ProductConstants.CORE_MONITOR:
			                               System.out.println("in fetch monitor products");
                                        try { List<Product> monitor = monitorService.getAllMonitor();
                                           // non empty list
                                          return new ResponseEntity<>(monitor, HttpStatus.OK);}
        
                                        catch(Exception e) 
                                           {// chk if empty
       	                                       //if (motherboard.isEmpty())
                                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                  }
			                                 
		case ProductConstants.CORE_OPTICAL:  
			                                 System.out.println("in fetch optical drive products");
                                              try { List<Product> optical = opticalDriveService.getAllOpticalDrive();
                                              // non empty list
                                                   return new ResponseEntity<>(optical, HttpStatus.OK);}

                                                   catch(Exception e) 
                                                     {// chk if empty
                                                     //if (motherboard.isEmpty())
                                                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                      }
			
		case ProductConstants.CORE_POWERSUPPLY:                   
			                                    System.out.println("in fetch power supply  products");
                                                try { List<Product> powerSupply = powerSupplyService.getAllPowerSupply();
                                                // non empty list
                                               return new ResponseEntity<>(powerSupply, HttpStatus.OK);}
     
                                                 catch(Exception e) 
                                                  {// chk if empty
                                                   //if (motherboard.isEmpty())
                                                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                } 
			
		case ProductConstants.CORE_RAM:    
			                             System.out.println("in fetch ram  products");
                                       try { List<Product> ram = ramService.getAllRAMMemory();
                                           // non empty list
                                       return new ResponseEntity<>(ram, HttpStatus.OK);}

                                       catch(Exception e) 
                                     {// chk if empty
                                        //if (motherboard.isEmpty())
                                       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                }
		
		case ProductConstants.CORE_STORAGE:
			
			 System.out.println("in fetch storage products");
             try { List<Product> storage = storageService.getAllStorage();
                 // non empty list
             return new ResponseEntity<>(storage, HttpStatus.OK);}

             catch(Exception e) 
           {// chk if empty
              //if (motherboard.isEmpty())
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                      }
			
		case ProductConstants.CORE_EXTSTORAGE:
			
			 System.out.println("in fetch external storage products");
             try { List<Product> externalStorage = externalStorageService.getAllExternalStorage();
                 // non empty list
             return new ResponseEntity<>(externalStorage, HttpStatus.OK);}

             catch(Exception e) 
           {// chk if empty
              //if (motherboard.isEmpty())
            	 
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                      }
             
             
		case ProductConstants.CORE_SOFTWARE:  
			
			 System.out.println("in fetch software products");
             try { List<Product> software = softwareService.getAllSoftware();
                 // non empty list
             return new ResponseEntity<>(software, HttpStatus.OK);}

             catch(Exception e) 
           {   // chk if empty
              //if (motherboard.isEmpty())
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                      }
             
             
		case ProductConstants.CORE_OS:
			
			                                        System.out.println("in fetch external storage products");
                                                     try { List<Product> operatingSystem = operatingSystemService.getAllOperatingSystem();
                                                       // non empty list
                                                       return new ResponseEntity<>(operatingSystem, HttpStatus.OK);}

                                                       catch(Exception e) 
                                                          {   // chk if empty
                                                       //if (motherboard.isEmpty())
                                                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                      }
             
             
             
             
 //************************************* ACCESSORIES (5) ***************************************
             
             
                case ProductConstants.ACC_CASE:          
		 	                             System.out.println("in fetch caseAcc products");
                                           try { List<Product>caseAcc= caseAccService.getAllCaseAccessory();
                                               // non empty list
                                         return new ResponseEntity<>(caseAcc, HttpStatus.OK);}

                                            catch(Exception e) 
                                         {   // chk if empty
                                           //if (motherboard.isEmpty())
                                             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                     }
    
                                                      
                                                     
                 case ProductConstants.ACC_FAN_CONTROLLER:     
	
	
	                                                  System.out.println("in fetch fanController products");
                                                      try { List<Product> fanController = fanControllerAccService.getAllFanControllerAccessory();
                                                           // non empty list
                                                          return new ResponseEntity<>(fanController, HttpStatus.OK);}

                                                         catch(Exception e) 
                                                          {   // chk if empty
                                                               //if (motherboard.isEmpty())
                                                          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                             }
			                                   
		
                   case ProductConstants.ACC_THERMAL_COMPOUND:  
	                         
	                                                    System.out.println("in fetch thermalAcc products");
                                                         try { List<Product> thermalAcc = thermalAccService.getAllThermalCompoundAccessory();
                                                           // non empty list
                                                            return new ResponseEntity<>(thermalAcc, HttpStatus.OK);}

                                                       catch(Exception e) 
                                                          {   // chk if empty
                                                               //if (motherboard.isEmpty())
                                                               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                              }
			
			
			
			
		case ProductConstants.ACC_UPS:
			
            
                                             System.out.println("in fetch upsAcc products");
                                                   try { List<Product> upsAcc = upsAccService.getAllUPSAccessory();
                                                 // non empty list
                                          return new ResponseEntity<>(upsAcc, HttpStatus.OK);}

                                        catch(Exception e) 
                                              {   // chk if empty
                                             //if (motherboard.isEmpty())
                                                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                      }
			
			
		case ProductConstants.ACC_CASE_FAN:
			
			                                    System.out.println("in fetch caseFanAcc products");
                                                try { List<Product>   caseFanAcc = caseFanAccService.getAllCaseFanAccessory();
                                                  // non empty list
                                                  return new ResponseEntity<>(caseFanAcc, HttpStatus.OK);}

                                                    catch(Exception e) 
                                                    {   // chk if empty
                                                     //if (motherboard.isEmpty())
                                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                     }
			                                          
   //************************************* NETWORKING (3) ******************************************
             
		case ProductConstants.NW_SOUND_CARD:
			                             
			                                          System.out.println("in fetch soundCard products");
                                                        try { List<Product>  soundCard = soundCardService.getAllSoundCards();
                                                         // non empty list
                                                        return new ResponseEntity<>(soundCard, HttpStatus.OK);}

                                                        catch(Exception e) 
                                                        {   // chk if empty
                                                        //if (motherboard.isEmpty())
                                                            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                                         }
			
			
		case ProductConstants.NW_WIRED_CARD:
			
			
			System.out.println("in fetch wiredService products");
            try { List<Product> wired = wiredService.getAllWiredNetworkAdapters();
             // non empty list
            return new ResponseEntity<>(wired, HttpStatus.OK);}

            catch(Exception e) 
            {   // chk if empty
            //if (motherboard.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }

			
		case ProductConstants.NW_WIRELESS_CARD:
			
			
			System.out.println("in fetch wiredless products");
            try { List<Product> wireless = wirelessService.getAllWireLessNetworkAdapters();
             // non empty list
            return new ResponseEntity<>(wireless, HttpStatus.OK);}

            catch(Exception e) 
            {   // chk if empty
            //if (motherboard.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
			
		//************************************* PERIPHERALS (5) ******************************************
			
		case ProductConstants.PERI_HEADPHONES:
			                               
			System.out.println("in fetch headphone products");
            try { List<Product> headphone = headphoneService.getAllHeadphones();
             // non empty list
            return new ResponseEntity<>(headphone, HttpStatus.OK);}

            catch(Exception e) 
            {   // chk if empty
            //if (motherboard.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
			                         
			
			
			
		case ProductConstants.PERI_KEYBOARD:
			
			System.out.println("in fetch keyboard products");
            try { List<Product> keyboard = keyboardService.getAllKeyboard();
             // non empty list
            return new ResponseEntity<>(keyboard, HttpStatus.OK);}

            catch(Exception e) 
            {   // chk if empty
            //if (motherboard.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
			    
		case ProductConstants.PERI_MICE:
			                     
			
			System.out.println("in fetch  mice products");
            try { List<Product>  mice =  miceService.getAllMice();
             // non empty list
            return new ResponseEntity<>( mice, HttpStatus.OK);}

            catch(Exception e) 
            {   // chk if empty
            //if (motherboard.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
			                           
		case ProductConstants.PERI_SPEAKER:
			              
			System.out.println("in fetch  speaker products");
            try { List<Product> speaker = speakerService.getAllSpeakers();
             // non empty list
            return new ResponseEntity<>( speaker, HttpStatus.OK);}

            catch(Exception e) 
            {   // chk if empty
            //if (motherboard.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
			                
		case ProductConstants.PERI_WEBCAM:
			
			
			System.out.println("in fetch  webcam products");
            try { List<Product> webcam = webcamService.getAllWebcams();
             // non empty list
            return new ResponseEntity<>( webcam, HttpStatus.OK);}

            catch(Exception e) 
            {   // chk if empty
            //if (motherboard.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
			
		default:
			break;
		}
		return null;
	}

		
		
		
		
		
		
//#############################################   GET BY ID  ############################################################################
	
	
	@GetMapping("/{type}/{id}")
	public ResponseEntity<?> showCpuDetailById(@PathVariable int id, @PathVariable String type) {
		switch (type) {
		
		//*******************************  CORE(13) *******************************************
		case ProductConstants.CORE_CPU:
			
			
			System.out.println("in get cpu dtls " + id);
			try {
				return ResponseEntity.ok(cpuService.getCpuById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		
		case ProductConstants.CORE_COOLER:
			
			System.out.println("in get cpu cooler dtls " + id);
			try {
				return ResponseEntity.ok(coolerService.getCpuCoolerById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		case ProductConstants.CORE_CASE:
			                        
			System.out.println("in get cpuCase dtls " + id);
			try {
				return ResponseEntity.ok(cpuCaseService.getCpuCaseById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		case ProductConstants.CORE_GPU:
			
			
			System.out.println("in get gpu dtls " + id);
			try {
				return ResponseEntity.ok(gpuService.getGraphicsCardById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		case ProductConstants.CORE_MOBO:
			                  
			
			System.out.println("in getmother dtls " + id);
			try {
				return ResponseEntity.ok(motherService.getMotherboardById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			               
			
		case ProductConstants.CORE_MONITOR:
			
			              
			System.out.println("in monitor dtls " + id);
			try {
				return ResponseEntity.ok(monitorService.getMonitorById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		case ProductConstants.CORE_OPTICAL:
			
			System.out.println("in opticalDrive dtls " + id);
			try {
				return ResponseEntity.ok(opticalDriveService.getOpticalDriveById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		case ProductConstants.CORE_POWERSUPPLY:
			
			System.out.println("in powerSupply dtls " + id);
			try {
				return ResponseEntity.ok(powerSupplyService.getPowerSupplyById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		case ProductConstants.CORE_RAM:
			
			
			System.out.println("in ram dtls " + id);
			try {
				return ResponseEntity.ok(ramService.getRAMMemoryById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		case ProductConstants.CORE_STORAGE:
			
			                     
			System.out.println("in storage dtls " + id);
			try {
				return ResponseEntity.ok(storageService.getStorageById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		case ProductConstants.CORE_EXTSTORAGE:	
			
			System.out.println("in externalStorage dtls " + id);
			try {
				return ResponseEntity.ok(externalStorageService.getExternalStorageById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		case ProductConstants.CORE_OS:
			
			
			System.out.println("in operatingSystem dtls " + id);
			try {
				return ResponseEntity.ok(operatingSystemService.getOperatingSystemById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			                          
		case ProductConstants.CORE_SOFTWARE:
			
			System.out.println("in  software dtls " + id);
			try {
				return ResponseEntity.ok( softwareService.getSoftwareById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
			
			
		//************************************* ACCESSORIES (5) ***************************************
		case ProductConstants.ACC_CASE:
			
			
			System.out.println("in caseAcc dtls " + id);
			try {
				return ResponseEntity.ok(caseAccService.getCaseAccessoryById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		case ProductConstants.ACC_FAN_CONTROLLER:
			
			
			System.out.println("in fanControllerAcc dtls " + id);
			try {
				return ResponseEntity.ok(fanControllerAccService.getFanControllerAccessoryById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		case ProductConstants.ACC_THERMAL_COMPOUND:
			
			
			System.out.println("in thermalAcc dtls " + id);
			try {
				return ResponseEntity.ok(thermalAccService.getThermalCompoundAccessoryById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		case ProductConstants.ACC_UPS:
			
			System.out.println("in tupsAcc dtls " + id);
			try {
				return ResponseEntity.ok(upsAccService.getUPSAccessoryById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		case ProductConstants.ACC_CASE_FAN:
			
			          
			System.out.println("in caseFanAcc dtls " + id);
			try {
				return ResponseEntity.ok(caseFanAccService.getCaseFanAccessoryById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		//************************************* NETWORKING (3) ******************************************
		
		case ProductConstants.NW_SOUND_CARD:
			
			
			System.out.println("in soundCard dtls " + id);
			try {
				return ResponseEntity.ok(soundCardService.getSoundCardById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		case ProductConstants.NW_WIRED_CARD:
			
			
			System.out.println("in wired dtls " + id);
			try {
				return ResponseEntity.ok(wiredService.getWiredNetworkAdapterById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		case ProductConstants.NW_WIRELESS_CARD:
			
			
			
			System.out.println("in wireless dtls " + id);
			try {
				return ResponseEntity.ok(wirelessService.getWireLessNetworkAdapterById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
			
			//************************************* PERIPHERALS (5) ******************************************
		case ProductConstants.PERI_HEADPHONES:
			
			
			System.out.println("in headphone dtls " + id);
			try {
				return ResponseEntity.ok(headphoneService.getHeadphoneById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		case ProductConstants.PERI_KEYBOARD:
			
			
			System.out.println("in keyboard dtls " + id);
			try {
				return ResponseEntity.ok(keyboardService.getKeyboardById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		case ProductConstants.PERI_MICE:
			
			
			
			System.out.println("in mice dtls " + id);
			try {
				return ResponseEntity.ok(miceService.getMiceById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		case ProductConstants.PERI_SPEAKER:	
			
			
			System.out.println("in speaker dtls " + id);
			try {
				return ResponseEntity.ok(speakerService.getSpeakerById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		case ProductConstants.PERI_WEBCAM:
			
			System.out.println("in webcam dtls " + id);
			try {
				return ResponseEntity.ok(webcamService.getWebcamById(id));
			} catch (RuntimeException e) {
				System.out.println("err in controller " + e);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		default:
			break;
		}
		
			return null;
		
	}

	
	
//################################################ DELETE BY ID #############################################################################
	
	
	
	@DeleteMapping("/{type}/{id}")
	public Product deleteCpuDetailById(@PathVariable int id, @PathVariable String type) {
		switch (type) {
		
		//*******************************  CORE(13) *******************************************
				case ProductConstants.CORE_CPU:
				
				case ProductConstants.CORE_COOLER:
					
				case ProductConstants.CORE_CASE:
					
				case ProductConstants.CORE_GPU:
				
				case ProductConstants.CORE_MOBO:
					
				case ProductConstants.CORE_MONITOR:
				
				case ProductConstants.CORE_OPTICAL:
					
				case ProductConstants.CORE_POWERSUPPLY:
				
				case ProductConstants.CORE_RAM:
					
				case ProductConstants.CORE_STORAGE:
				case ProductConstants.CORE_EXTSTORAGE:	
				case ProductConstants.CORE_OS:
				case ProductConstants.CORE_SOFTWARE:
					
				//************************************* ACCESSORIES (5) ***************************************
				case ProductConstants.ACC_CASE:
					
				case ProductConstants.ACC_FAN_CONTROLLER:
					
				case ProductConstants.ACC_THERMAL_COMPOUND:
					
				case ProductConstants.ACC_UPS:
				case ProductConstants.ACC_CASE_FAN:
				//************************************* NETWORKING (3) ******************************************
				case ProductConstants.NW_SOUND_CARD:
					
				case ProductConstants.NW_WIRED_CARD:
				case ProductConstants.NW_WIRELESS_CARD:
					//************************************* PERIPHERALS (5) ******************************************
				case ProductConstants.PERI_HEADPHONES:
				case ProductConstants.PERI_KEYBOARD:
				case ProductConstants.PERI_MICE:
				case ProductConstants.PERI_SPEAKER:	
				case ProductConstants.PERI_WEBCAM:
				default:
					break;
				}		if (type.equalsIgnoreCase("cpu"))
			;
		return cpuService.deleteCpuById(id);
	}

//	@PutMapping("/{type}/{id}")
//	  public Cpu updateCpuDetailById(@PathVariable int id,@PathVariable String type) {
//		  return service.updateCpuById(id, obj);
//	  }

	
//################################################ CREATE PRODUCT #############################################################################
	
	@PostMapping("/{type}")
	public Product createProduct(@RequestBody String product, @PathVariable String type) {
		switch (type) {
		
		//*******************************  CORE(13) *******************************************
				case ProductConstants.CORE_CPU:
				
				case ProductConstants.CORE_COOLER:
					
				case ProductConstants.CORE_CASE:
					
				case ProductConstants.CORE_GPU:
				
				case ProductConstants.CORE_MOBO:
					
				case ProductConstants.CORE_MONITOR:
				
				case ProductConstants.CORE_OPTICAL:
					
				case ProductConstants.CORE_POWERSUPPLY:
				
				case ProductConstants.CORE_RAM:
					
				case ProductConstants.CORE_STORAGE:
				case ProductConstants.CORE_EXTSTORAGE:	
					
				case ProductConstants.CORE_OS:
				case ProductConstants.CORE_SOFTWARE:
					
				//************************************* ACCESSORIES (5) ***************************************
				case ProductConstants.ACC_CASE:
					
				case ProductConstants.ACC_FAN_CONTROLLER:
					
				case ProductConstants.ACC_THERMAL_COMPOUND:
					
				case ProductConstants.ACC_UPS:
				case ProductConstants.ACC_CASE_FAN:
				//************************************* NETWORKING (3) ******************************************
				case ProductConstants.NW_SOUND_CARD:
					
				case ProductConstants.NW_WIRED_CARD:
				case ProductConstants.NW_WIRELESS_CARD:
					//************************************* PERIPHERALS (5) ******************************************
				case ProductConstants.PERI_HEADPHONES:
				case ProductConstants.PERI_KEYBOARD:
				case ProductConstants.PERI_MICE:
				case ProductConstants.PERI_SPEAKER:	
				case ProductConstants.PERI_WEBCAM:
				default:
					break;
				}		if (type.equalsIgnoreCase(ProductConstants.CORE_CPU)) {
			try {
				Cpu newCpu = new ObjectMapper().readValue(product, Cpu.class);
				cpuService.createCpu(newCpu);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
//################################################ UPDATE PRODUCT #############################################################################
	
	@PutMapping("/{type}/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Cpu product, @PathVariable String type, @PathVariable int id) {
		switch (type) {
		//*******************************  CORE(13) *******************************************
				case ProductConstants.CORE_CPU:
				
				case ProductConstants.CORE_COOLER:
					
				case ProductConstants.CORE_CASE:
					
				case ProductConstants.CORE_GPU:
				
				case ProductConstants.CORE_MOBO:
					
				case ProductConstants.CORE_MONITOR:
				
				case ProductConstants.CORE_OPTICAL:
					
				case ProductConstants.CORE_POWERSUPPLY:
				
				case ProductConstants.CORE_RAM:
					
				case ProductConstants.CORE_STORAGE:
				case ProductConstants.CORE_EXTSTORAGE:	
				case ProductConstants.CORE_OS:
				case ProductConstants.CORE_SOFTWARE:
					
				//************************************* ACCESSORIES (5) ***************************************
				case ProductConstants.ACC_CASE:
					
				case ProductConstants.ACC_FAN_CONTROLLER:
					
				case ProductConstants.ACC_THERMAL_COMPOUND:
					
				case ProductConstants.ACC_UPS:
				case ProductConstants.ACC_CASE_FAN:
				//************************************* NETWORKING (3) ******************************************
				case ProductConstants.NW_SOUND_CARD:
					
				case ProductConstants.NW_WIRED_CARD:
				case ProductConstants.NW_WIRELESS_CARD:
					//************************************* PERIPHERALS (5) ******************************************
				case ProductConstants.PERI_HEADPHONES:
				case ProductConstants.PERI_KEYBOARD:
				case ProductConstants.PERI_MICE:
				case ProductConstants.PERI_SPEAKER:	
				case ProductConstants.PERI_WEBCAM:
				default:
					break;
				}
		System.out.println("in update product " + product);
		try {
			return ResponseEntity.ok(cpuService.updateCpuById(product));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}