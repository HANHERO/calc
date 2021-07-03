package model.unaryTests;

import model.DivisionByZeroException;
import model.MainModel;
import controllers.OverflowException;
import model.NegativeSqrtException;
import model.UnaryOperations;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class Sqrt {
    MainModel testModel = new MainModel();

    @Test
    public void sqrtScenarios() throws OverflowException, DivisionByZeroException, NegativeSqrtException {
        assertSQRT("0", "0");
        assertSQRT("1", "1");
        assertSQRT("2", "1.414213562373095048801688724209698");
        assertSQRT("3", "1.732050807568877293527446341505872");
        assertSQRT("4", "2");
        assertSQRT("5", "2.236067977499789696409173668731276");
        assertSQRT("6", "2.449489742783178098197284074705891");
        assertSQRT("7", "2.64575131106459059050161575363926");
        assertSQRT("8", "2.828427124746190097603377448419396");
        assertSQRT("9", "3");
        assertSQRT("10", "3.162277660168379331998893544432719");
        assertSQRT("11", "3.316624790355399849114932736670687");
        assertSQRT("14", "3.741657386773941385583748732316549");
        assertSQRT("19", "4.358898943540673552236981983859616");
        assertSQRT("20", "4.472135954999579392818347337462552");
        assertSQRT("21", "4.582575694955840006588047193728008");
        assertSQRT("26", "5.099019513592784830028224109022782");
        assertSQRT("29", "5.38516480713450403125071049154033");
        assertSQRT("30", "5.477225575051661134569697828008021");
        assertSQRT("31", "5.56776436283002192211947129891855");
        assertSQRT("33", "5.744562646538028659850611468218929");
        assertSQRT("38", "6.164414002968976450250192381454244");
        assertSQRT("43", "6.557438524302000652344109997636002");
        assertSQRT("44", "6.633249580710799698229865473341373");
        assertSQRT("49", "7");
        assertSQRT("50", "7.07106781186547524400844362104849");
        assertSQRT("51", "7.141428428542849997999399811367265");
        assertSQRT("54", "7.348469228349534294591852224117674");
        assertSQRT("55", "7.416198487095662948711397440800713");
        assertSQRT("62", "7.874007874011811019685034448812008");
        assertSQRT("65", "8.062257748298549652366613230303771");
        assertSQRT("66", "8.12403840463596036045988356826604");
        assertSQRT("74", "8.602325267042626771729473535049714");
        assertSQRT("76", "8.717797887081347104473963967719231");
        assertSQRT("77", "8.77496438739212206040638830741631");
        assertSQRT("86", "9.273618495495703752516416073990175");
        assertSQRT("87", "9.327379053088815045554475542320557");
        assertSQRT("88", "9.380831519646859109131260227088933");
        assertSQRT("98", "9.899494936611665341611821069467887");
        assertSQRT("99", "9.94987437106619954734479821001206");
        assertSQRT("100", "10");
        assertSQRT("101", "10.04987562112089027021926491275958");
        assertSQRT("108", "10.39230484541326376116467804903523");
        assertSQRT("111", "10.53565375285273884840140466189967");
        assertSQRT("129", "11.35781669160054722178467596798471");
        assertSQRT("138", "11.74734012447073058696850636596467");
        assertSQRT("145", "12.04159457879229548012824103037861");
        assertSQRT("152", "12.32882800593795290050038476290849");
        assertSQRT("161", "12.68857754044952038019377274608949");
        assertSQRT("171", "13.07669683062202065671094595157885");
        assertSQRT("185", "13.60147050873544334502993737205739");
        assertSQRT("197", "14.03566884761819963051946138640705");
        assertSQRT("210", "14.49137674618943857371866415716977");
        assertSQRT("211", "14.52583904633395006832875784543728");
        assertSQRT("214", "14.62873883832779345718375423804348");
        assertSQRT("222", "14.89966442575133971933181604612395");
        assertSQRT("226", "15.03329637837290827087893056309936");
        assertSQRT("237", "15.39480431834065242594933371743215");
        assertSQRT("244", "15.6204993518133087882594454715182");
        assertSQRT("253", "15.90597372058686635374547783054056");
        assertSQRT("260", "16.12451549659709930473322646060754");
        assertSQRT("278", "16.67333200053306681591045628341639");
        assertSQRT("286", "16.9115345252877628981725179227766");
        assertSQRT("301", "17.34935157289747241232499427699982");
        assertSQRT("314", "17.72004514666935040199112509753632");
        assertSQRT("322", "17.94435844492636075474345489372992");
        assertSQRT("328", "18.11077027627483325314761633396813");
        assertSQRT("331", "18.19340539866025191738444620915027");
        assertSQRT("333", "18.2482875908946590669990527356062");
        assertSQRT("348", "18.65475810617763009110895108464111");
        assertSQRT("356", "18.86796226411320762264132075524528");
        assertSQRT("367", "19.15724406066801666041816230171794");
        assertSQRT("376", "19.39071942966531605629776230169063");
        assertSQRT("389", "19.7230829233160199680639990832478");
        assertSQRT("403", "20.07485989988473120053970371927405");
        assertSQRT("418", "20.44504830026087270236314250803608");
        assertSQRT("428", "20.68816086557720093947719888525399");
        assertSQRT("431", "20.76053949202669443962249628534107");
        assertSQRT("433", "20.80865204668481163077090152210335");
        assertSQRT("444", "21.07130750570547769680280932379933");
        assertSQRT("449", "21.18962010041709077171765895152004");
        assertSQRT("453", "21.28379665379276263865298091839357");
        assertSQRT("467", "21.61018278497430942079371541961115");
        assertSQRT("479", "21.88606862823928915224506214368474");
        assertSQRT("492", "22.18107301281883432410320020521987");
        assertSQRT("512", "22.62741699796952078082701958735517");
        assertSQRT("524", "22.89104628451919407808686857638437");
        assertSQRT("539", "23.21637353248779894380452915669481");
        assertSQRT("544", "23.32380757938120188349661151018233");
        assertSQRT("547", "23.38803112705299954189250278075704");
        assertSQRT("553", "23.51595203260969402677399272375153");
        assertSQRT("555", "23.55843797877949292626468018663948");
        assertSQRT("562", "23.70653918225939616874298918549843");
        assertSQRT("570", "23.87467277262664389793646461428408");
        assertSQRT("574", "23.95829710142187881120270147760737");
        assertSQRT("582", "24.12467616362963741410126626632729");
        assertSQRT("586", "24.20743687382040866364148195840721");
        assertSQRT("599", "24.47447650104083431567814461582675");
        assertSQRT("612", "24.73863375370596329892845913584446");
        assertSQRT("614", "24.77902338672773439133696781635673");
        assertSQRT("628", "25.05992817228333557699072963150573");
        assertSQRT("638", "25.25866188063017719922863302324653");
        assertSQRT("642", "25.33771891863985454611219604499955");
        assertSQRT("655", "25.59296778413945489644313757582343");
        assertSQRT("657", "25.63201123595259350361494497871912");
        assertSQRT("661", "25.70992026436488192322670015539536");
        assertSQRT("666", "25.80697580112788031518842060514914");
        assertSQRT("679", "26.05762844159076576343778475271471");
        assertSQRT("683", "26.13426869074395967150834638501547");
        assertSQRT("690", "26.26785107312739429373922144997694");
        assertSQRT("704", "26.53299832284319879291946189336549");
        assertSQRT("718", "26.79552201394852467896387051687845");
        assertSQRT("721", "26.85144316419510439420271925380083");
        assertSQRT("739", "27.18455443813637347216581593832355");
        assertSQRT("742", "27.23967694375247174987088807534185");
        assertSQRT("756", "27.49545416973504003952828316236805");
        assertSQRT("763", "27.62245463386626688225375827859922");
        assertSQRT("766", "27.67670500619609523535421582580767");
        assertSQRT("777", "27.87471972953270789531596912111625");
        assertSQRT("785", "28.0178514522437997738574876085803");
        assertSQRT("812", "28.49561369755001433771537916122508");
        assertSQRT("824", "28.70540018881464749400859928294454");
        assertSQRT("831", "28.82707061079914862877843697537468");
        assertSQRT("847", "29.10326442171049649551777329003186");
        assertSQRT("856", "29.25747767665558691436750847608696");
        assertSQRT("862", "29.35983651180639663747121000552419");
        assertSQRT("877", "29.61418578992169421552065349226198");
        assertSQRT("879", "29.64793416074718687245360692911146");
        assertSQRT("882", "29.69848480983499602483546320840366");
        assertSQRT("888", "29.7993288515026794386636320922479");
        assertSQRT("893", "29.88310559496786973798796978159698");
        assertSQRT("905", "30.08321791298264687687301696655296");
        assertSQRT("914", "30.23243291566194809539630834435941");
        assertSQRT("927", "30.44667469527665840594556035680762");
        assertSQRT("935", "30.57776970284131105206026441335648");
        assertSQRT("946", "30.75711299845939701814059307927057");
        assertSQRT("952", "30.85449724108302497815756107417757");
        assertSQRT("963", "31.03224129836580140921579832788099");
        assertSQRT("977", "31.25699921617556684293531026659993");
        assertSQRT("986", "31.40063693621516334097767845253971");
        assertSQRT("988", "31.43246729100342196043677397825605");
        assertSQRT("999", "31.606961258558216545204213985699");
        assertSQRT("1000", "31.62277660168379331998893544432719");
        assertSQRT("1001", "31.63858403911274914310629158480098");
        assertSQRT("1008", "31.74901573277508708601938904367113");
        assertSQRT("1111", "33.33166662499791653644921806635253");
        assertSQRT("1114", "33.37663853655727266638259295039188");
        assertSQRT("1226", "35.01428280002319282118780770933062");
        assertSQRT("1314", "36.24913792078371620484851780042357");
        assertSQRT("1403", "37.45664160065608444724485861538216");
        assertSQRT("1524", "39.03844259188627007285079792949122");
        assertSQRT("1628", "40.34848200366402879774479363274803");
        assertSQRT("1718", "41.44876355212541198343518046753255");
        assertSQRT("1812", "42.56759330758552527730596183678714");
        assertSQRT("1905", "43.64630568559038995358046005609731");
        assertSQRT("2013", "44.86646854834911118157609672300811");
        assertSQRT("2175", "46.63689526544407522777237771160278");
        assertSQRT("2112", "45.95650117230422927880489174575143");
        assertSQRT("2222", "47.13809499757070157368576847617524");
        assertSQRT("2256", "47.49736834815166893869167040164871");
        assertSQRT("2367", "48.6518242206805643227280495198113");
        assertSQRT("2498", "49.97999599839919955173103093010273");
        assertSQRT("2596", "50.9509568114279871567534636517864");
        assertSQRT("2696", "51.92301994298867820814071665655302");
        assertSQRT("2731", "52.25897052181567803296159643981273");
        assertSQRT("2891", "53.76802023508025723038780915211961");
        assertSQRT("2964", "54.44263035526479776773204625724778");
        assertSQRT("3015", "54.90901565316938004961262704862491");
        assertSQRT("3173", "56.32938842203064430497749476281872");
        assertSQRT("3224", "56.78027826631355986912469704563736");
        assertSQRT("3265", "57.14017850864661063252747910622525");
        assertSQRT("3324", "57.65414122159829725755687395074936");
        assertSQRT("3333", "57.73214009544423600866343957388859");
        assertSQRT("3477", "58.96609195122227192553928488167375");
        assertSQRT("3531", "59.42221806698231960571859552800071");
        assertSQRT("3647", "60.39039658753699557459665301065746");
        assertSQRT("3787", "61.53860576906174919421740163211897");
        assertSQRT("3889", "62.36184731067545917522903920934698");
        assertSQRT("3932", "62.70566162636353205549277050893125");
        assertSQRT("4077", "63.85138996137828791595894275518072");
        assertSQRT("4178", "64.63745044476924601898990287905258");
        assertSQRT("4222", "64.9769189789728334114907653997805");
        assertSQRT("4336", "65.84831053261731179068072651271379");
        assertSQRT("4378", "66.16645675869307118689282476456331");
        assertSQRT("4425", "66.52067347825035362523015407061732");
        assertSQRT("4444", "66.66333324999583307289843613270507");
        assertSQRT("4554", "67.48333127521195511420723854173396");
        assertSQRT("4647", "68.16890786861705326670717174812848");
        assertSQRT("4781", "69.14477565225011271328737757483419");
        assertSQRT("4856", "69.68500556073738306809038206964085");
        assertSQRT("4986", "70.6116137756389193260906447970127");
        assertSQRT("5086", "71.31619731870173123806087490800171");
        assertSQRT("5154", "71.79136438319026682070854242213725");
        assertSQRT("5243", "72.40856302952020328817019609838898");
        assertSQRT("5323", "72.9588925354545112423614272418216");
        assertSQRT("5416", "73.59347797189639548772370435745382");
        assertSQRT("5448", "73.81056834898373819728870311529277");
        assertSQRT("5555", "74.53187237685633240219234482912433");
        assertSQRT("5570", "74.63243262818116127710020635903852");
        assertSQRT("5631", "75.03998933901843245916855380221451");
        assertSQRT("5960", "77.20103626247513006889445172288193");
        assertSQRT("6036", "77.69169839822012798214765282824649");
        assertSQRT("6271", "79.18964578781748787574187128352015");
        assertSQRT("6354", "79.71198153351853540911229125591418");
        assertSQRT("6429", "80.1810451416043840532896423143927");
        assertSQRT("6519", "80.74032449773780789049765639014558");
        assertSQRT("6560", "80.99382692526634773298760915960468");
        assertSQRT("6666", "81.64557550780078860451628329294861");
        assertSQRT("6667", "81.6516993087100423023537439293147");
        assertSQRT("6753", "82.17663901620703299715952170682584");
        assertSQRT("6874", "82.90958931269651392326218249760652");
        assertSQRT("6950", "83.36666000266533407955228141708194");
        assertSQRT("7071", "84.08923831264022098913592379005892");
        assertSQRT("7118", "84.36824046997780076436859882751764");
        assertSQRT("7224", "84.9941174435031121230719388328364");
        assertSQRT("7335", "85.64461454172118579773245786301652");
        assertSQRT("7452", "86.32496741962895174875388515492849");
        assertSQRT("7589", "87.11486669908873826009751331021316");
        assertSQRT("7672", "87.58995376183275506273449714902567");
        assertSQRT("7765", "88.11923740024081710902290449871734");
        assertSQRT("7777", "88.18730067305609507829071123598803");
        assertSQRT("7850", "88.60022573334675200995562548768158");
        assertSQRT("7919", "88.98876333560322041655123605909505");
        assertSQRT("8072", "89.84430978086480909019039772758731");
        assertSQRT("8146", "90.25519375637060810397637284106739");
        assertSQRT("8230", "90.71934744033380666918898073760001");
        assertSQRT("8336", "91.30169768410661924497489627827478");
        assertSQRT("8419", "91.75510884958940530154377018099739");
        assertSQRT("8591", "92.6876475049399449369755389682301");
        assertSQRT("8636", "92.9300812439115432413491551439811");
        assertSQRT("8745", "93.51470472604829863362379915793902");
        assertSQRT("8784", "93.72299611087985272955667282910922");
        assertSQRT("8855", "94.10100955887774108594133416080332");
        assertSQRT("8888", "94.27618999514140314737153695235048");
        assertSQRT("8958", "94.64671151181112219551599208221085");
        assertSQRT("9083", "95.3047742770528783964258840394252");
        assertSQRT("9112", "95.45679651025378926211325248992706");
        assertSQRT("9214", "95.9895827681316677156367919822515");
        assertSQRT("9335", "96.61780374237452102321179118281583");
        assertSQRT("9487", "97.40123202506218812187040265847961");
        assertSQRT("9522", "97.58073580374355836731652197046917");
        assertSQRT("9672", "98.34632682515397331223598697032028");
        assertSQRT("9755", "98.7674035297071075130444618968262");
        assertSQRT("9826", "99.12618221237010800486059891827491");
        assertSQRT("9989", "99.94498486667552645200049183632765");
        assertSQRT("9896", "99.47864092356710519476242438661525");
        assertSQRT("10000", "100");
        assertSQRT("55555", "235.7010818812675709013134913829657");
        assertSQRT("82534", "287.2873126331895639008780453329172");
        assertSQRT("437903", "661.7423970095916409901026792024608");
        assertSQRT("840736", "916.9165719955114869490982726237562");
        assertSQRT("2234567", "1494.846814894422551580595702170743");
        assertSQRT("4534074", "2129.336516382509230366687303051981");
        assertSQRT("49771169", "7054.868460857367395852545856576398");
        assertSQRT("72324911", "8504.405387797550187994343413208119");
        assertSQRT("659254843", "25675.95846312265710820613729456411");
        assertSQRT("888888888", "29814.23968509007609839693764265949");
        assertSQRT("1874764566", "43298.55154621225894663505224937084");
        assertSQRT("6243776665", "79017.57187486844055612144619644279");
        assertSQRT("47037036736", "216880.2359275736309940994832572506");
        assertSQRT("444444444444", "666666.66666633333333333325");
        assertSQRT("1000000000000", "1000000");
        assertSQRT("6578868631288", "2564930.531474098227882030476387806");
        assertSQRT("8407407347404", "2899552.956475187400539098299256738");
        assertSQRT("34691357824690", "5889936.996665584028223194078914574");
        assertSQRT("96419752386415", "9819356.006705073120632452599079419");
        assertSQRT("109975967636925", "10486942.7211616351042036874920912");
        assertSQRT("565933996761014", "23789367.30476483269013414176498568");
        assertSQRT("1000000000000000", "31622776.60168379331998893544432719");
        assertSQRT("1082424349226241", "32900218.07262439711988681872826762");
        assertSQRT("1028962228779747", "32077441.11957415782795798423781053");
        assertSQRT("10000000000000000", "100000000");
        assertSQRT("1E+18", "1E+9");
        assertSQRT("5.647753E+23", "751515335838.1983145409957506060964");
        assertSQRT("8.8788779E+24", "2979744603149.739744486681768296681");
        assertSQRT("9.86859867454E+38", "31414325831601097722.76842278620604");
        assertSQRT("1E+296", "1E+148");
        assertSQRT("5.647753E+549", "7.515153358381983145409957506060964E+274");
        assertSQRT("8.8788779E+897", "9.422779791547715034610003242559177E+448");
        assertSQRT("9.86859867454E+978", "3.141432583160109772276842278620604E+489");
        assertSQRT("1E+1295", "3.162277660168379331998893544432719E+647");
        assertSQRT("1E+1296", "1E+648");
        assertSQRT("1E+1297", "3.162277660168379331998893544432719E+648");
        assertSQRT("5.647753E+1549", "7.515153358381983145409957506060964E+774");
        assertSQRT("8.8788779E+1897", "9.422779791547715034610003242559177E+948");
        assertSQRT("9.86859867454E+1978", "3.141432583160109772276842278620604E+989");
        assertSQRT("1E+2295", "3.162277660168379331998893544432719E+1147");
        assertSQRT("1E+2296", "1E+1148");
        assertSQRT("1E+2297", "3.162277660168379331998893544432719E+1148");
        assertSQRT("5.647753E+2549", "7.515153358381983145409957506060964E+1274");
        assertSQRT("8.8788779E+2897", "9.422779791547715034610003242559177E+1448");
        assertSQRT("9.86859867454E+2978", "3.141432583160109772276842278620604E+1489");
        assertSQRT("1E+3295", "3.162277660168379331998893544432719E+1647");
        assertSQRT("1E+3296", "1E+1648");
        assertSQRT("1E+3297", "3.162277660168379331998893544432719E+1648");
        assertSQRT("8.8788779E+3897", "9.422779791547715034610003242559177E+1948");
        assertSQRT("9.86859867454E+3978", "3.141432583160109772276842278620604E+1989");
        assertSQRT("1E+4295", "3.162277660168379331998893544432719E+2147");
        assertSQRT("1E+4296", "1E+2148");
        assertSQRT("1E+4297", "3.162277660168379331998893544432719E+2148");
        assertSQRT("5.647753E+4549", "7.515153358381983145409957506060964E+2274");
        assertSQRT("8.8788779E+4897", "9.422779791547715034610003242559177E+2448");
        assertSQRT("9.86859867454E+4978", "3.141432583160109772276842278620604E+2489");
        assertSQRT("1E+5295", "3.162277660168379331998893544432719E+2647");
        assertSQRT("1E+5296", "1E+2648");
        assertSQRT("1E+5297", "3.162277660168379331998893544432719E+2648");
        assertSQRT("5.647753E+5549", "7.515153358381983145409957506060964E+2774");
        assertSQRT("8.8788779E+5897", "9.422779791547715034610003242559177E+2948");
        assertSQRT("9.86859867454E+5978", "3.141432583160109772276842278620604E+2989");
        assertSQRT("1E+6295", "3.162277660168379331998893544432719E+3147");
        assertSQRT("1E+6296", "1E+3148");
        assertSQRT("1E+6297", "3.162277660168379331998893544432719E+3148");
        assertSQRT("5.647753E+6549", "7.515153358381983145409957506060964E+3274");
        assertSQRT("8.8788779E+6897", "9.422779791547715034610003242559177E+3448");
        assertSQRT("9.86859867454E+6978", "3.141432583160109772276842278620604E+3489");
        assertSQRT("1E+7295", "3.162277660168379331998893544432719E+3647");
        assertSQRT("1E+7296", "1E+3648");
        assertSQRT("1E+7297", "3.162277660168379331998893544432719E+3648");
        assertSQRT("5.647753E+7549", "7.515153358381983145409957506060964E+3774");
        assertSQRT("8.8788779E+7897", "9.422779791547715034610003242559177E+3948");
        assertSQRT("9.86859867454E+7978", "3.141432583160109772276842278620604E+3989");
        assertSQRT("1E+8295", "3.162277660168379331998893544432719E+4147");
        assertSQRT("1E+8296", "1E+4148");
        assertSQRT("1E+8297", "3.162277660168379331998893544432719E+4148");
        assertSQRT("5.647753E+8549", "7.515153358381983145409957506060964E+4274");
        assertSQRT("8.8788779E+8897", "9.422779791547715034610003242559177E+4448");
        assertSQRT("9.86859867454E+8978", "3.141432583160109772276842278620604E+4489");
        assertSQRT("1E+9295", "3.162277660168379331998893544432719E+4647");
        assertSQRT("1E+9296", "1E+4648");
        assertSQRT("1E+9297", "3.162277660168379331998893544432719E+4648");
        assertSQRT("5.647753E+9549", "7.515153358381983145409957506060964E+4774");
        assertSQRT("8.8788779E+9897", "9.422779791547715034610003242559177E+4948");
        assertSQRT("9.86859867454E+9978", "3.141432583160109772276842278620604E+4989");
        assertSQRT("1E+10295", "3.162277660168379331998893544432719E+5147");
        assertSQRT("1E+10296", "1E+5148");
        assertSQRT("1E+10297", "3.162277660168379331998893544432719E+5148");
        assertSQRT("5.647753E+10549", "7.515153358381983145409957506060964E+5274");
        assertSQRT("8.8788779E+10897", "9.422779791547715034610003242559177E+5448");
        assertSQRT("9.86859867454E+10978", "3.141432583160109772276842278620604E+5489");
        assertSQRT("9999999999999999E9999", "3.162277660168379173885010536013748E+5007");

        assertSQRT("0.001", "0.03162277660168379331998893544432719");
        assertSQRT("0.002", "0.04472135954999579392818347337462552");
        assertSQRT("0.003", "0.05477225575051661134569697828008021");
        assertSQRT("0.004", "0.06324555320336758663997787088865437");
        assertSQRT("0.004", "0.06324555320336758663997787088865437");
        assertSQRT("0.005", "0.0707106781186547524400844362104849");
        assertSQRT("0.006", "0.07745966692414833770358530799564799");
        assertSQRT("0.007", "0.08366600265340755479781720257851875");
        assertSQRT("0.008", "0.08944271909999158785636694674925105");
        assertSQRT("0.009", "0.09486832980505137995996680633298156");
        assertSQRT("0.010", "0.1");
        assertSQRT("0.00011", "0.01048808848170151546991453513679938");
        assertSQRT("0.00043", "0.02073644135332772087455898679984993");
        assertSQRT("0.00098", "0.03130495168499705574972843136223787");
        assertSQRT("0.00152", "0.0389871773792358556273536527995984");
        assertSQRT("0.00278", "0.05272570530585626978768650159881152");
        assertSQRT("0.00367", "0.0605805249234438377196232123846782");
        assertSQRT("0.00547", "0.07395944834840238314525940903928774");
        assertSQRT("0.00562", "0.07496665925596524806101997812828039");
        assertSQRT("0.00679", "0.08240145629781065950648257407195511");
        assertSQRT("0.00742", "0.08613942186943211659205252051940071");
        assertSQRT("0.00893", "0.09449867723941960024836249832849141");
        assertSQRT("0.00935", "0.09669539802906858090162169664147757");
        assertSQRT("0.00952", "0.09757048734120374372826490691707076");
        assertSQRT("0.00999", "0.09994998749374609101357260611157897");
        assertSQRT("0.01001", "0.100049987506246096482325828770011");
        assertSQRT("0.000001008", "0.001003992031840890657573806430942225");
        assertSQRT("0.000002256", "0.00150199866844148700130707746662159");
        assertSQRT("0.000003173", "0.001781291666179348631154442864974092");
        assertSQRT("0.000003477", "0.00186467155284784671377910203403317");
        assertSQRT("0.000003889", "0.001972054765973805302524573457465575");
        assertSQRT("0.000004378", "0.002092367080605121736008632788423028");
        assertSQRT("0.000004647", "0.002155690144710041578103499683061197");
        assertSQRT("0.000005448", "0.002334095113743225331976352950341111");
        assertSQRT("0.000006271", "0.002504196477914622417257610780084538");
        assertSQRT("0.000007118", "0.00266795802065924568025350622515925");
        assertSQRT("0.000008072", "0.002841126537132762061308776940806323");
        assertSQRT("0.000009112", "0.003018608951156144703450794682213255");
        assertSQRT("0.000009214", "0.003035457131965463945810519728492911");
        assertSQRT("0.000009999", "0.003162119542332326183114547050861703");
        assertSQRT("0.00001", "0.003162277660168379331998893544432719");
        assertSQRT("0.000010001", "0.003162435770098738305756997358238241");
        assertSQRT("0.000055555", "0.007453522657106504026622740625843189");
        assertSQRT("0.000082534", "0.009084822507897443782618228462932803");
        assertSQRT("0.072324911", "0.268932911708477956604684550871594");
        assertSQRT("1E-18", "1E-9");
        assertSQRT("5.647753E-11", "0.000007515153358381983145409957506060964");
        assertSQRT("8.8788779E-10", "0.00002979744603149739744486681768296681");
        assertSQRT("9.86859867454E-16", "3.141432583160109772276842278620604E-8");
        assertSQRT("1E-296", "1E-148");
        assertSQRT("5.647753E-537", "7.515153358381983145409957506060964E-269");
        assertSQRT("8.8788779E-883", "9.422779791547715034610003242559177E-442");
        assertSQRT("9.86859867454E-956", "3.141432583160109772276842278620604E-478");
        assertSQRT("1E-1296", "1E-648");
        assertSQRT("5.647753E-1537", "7.515153358381983145409957506060964E-769");
        assertSQRT("8.8788779E-1883", "9.422779791547715034610003242559177E-942");
        assertSQRT("9.86859867454E-1956", "3.141432583160109772276842278620604E-978");
        assertSQRT("1E-2296", "1E-1148");
        assertSQRT("5.647753E-2537", "7.515153358381983145409957506060964E-1269");
        assertSQRT("8.8788779E-2883", "9.422779791547715034610003242559177E-1442");
        assertSQRT("9.86859867454E-2956", "3.141432583160109772276842278620604E-1478");
        assertSQRT("1E-3296", "1E-1648");
        assertSQRT("5.647753E-3537", "7.515153358381983145409957506060964E-1769");
        assertSQRT("8.8788779E-3883", "9.422779791547715034610003242559177E-1942");
        assertSQRT("9.86859867454E-3956", "3.141432583160109772276842278620604E-1978");
        assertSQRT("1E-4296", "1E-2148");
        assertSQRT("5.647753E-4537", "7.515153358381983145409957506060964E-2269");
        assertSQRT("8.8788779E-4883", "9.422779791547715034610003242559177E-2442");
        assertSQRT("9.86859867454E-4956", "3.141432583160109772276842278620604E-2478");
        assertSQRT("1E-5296", "1E-2648");
        assertSQRT("5.647753E-5537", "7.515153358381983145409957506060964E-2769");
        assertSQRT("8.8788779E-5883", "9.422779791547715034610003242559177E-2942");
        assertSQRT("9.86859867454E-5956", "3.141432583160109772276842278620604E-2978");
        assertSQRT("1E-6296", "1E-3148");
        assertSQRT("5.647753E-6537", "7.515153358381983145409957506060964E-3269");
        assertSQRT("8.8788779E-6883", "9.422779791547715034610003242559177E-3442");
        assertSQRT("9.86859867454E-6956", "3.141432583160109772276842278620604E-3478");
        assertSQRT("1E-7296", "1E-3648");
        assertSQRT("5.647753E-7537", "7.515153358381983145409957506060964E-3769");
        assertSQRT("8.8788779E-7883", "9.422779791547715034610003242559177E-3942");
        assertSQRT("9.86859867454E-7956", "3.141432583160109772276842278620604E-3978");
        assertSQRT("1E-8296", "1E-4148");
        assertSQRT("5.647753E-8537", "7.515153358381983145409957506060964E-4269");
        assertSQRT("8.8788779E-8883", "9.422779791547715034610003242559177E-4442");
        assertSQRT("9.86859867454E-8956", "3.141432583160109772276842278620604E-4478");
        assertSQRT("1E-9296", "1E-4648");
        assertSQRT("5.647753E-9537", "7.515153358381983145409957506060964E-4769");
        assertSQRT("8.8788779E-9883", "9.422779791547715034610003242559177E-4942");
        assertSQRT("9.86859867454E-9956", "3.141432583160109772276842278620604E-4978");
        assertSQRT("1E-10296", "1E-5148");
        assertSQRT("5.647753E-10537", "7.515153358381983145409957506060964E-5269");
        assertSQRT("8.8788779E-10883", "9.422779791547715034610003242559177E-5442");
        assertSQRT("9.86859867454E-10956", "3.141432583160109772276842278620604E-5478");
        assertSQRT("1E-9998", "1E-4999");
        assertSQRT("1E-9999", "3.162277660168379331998893544432719E-5000");
        assertSQRT("1E-10000", "1E-5000");
        assertSQRT("0.0000000000000001", "1E-8");
        
    }

    private void assertSQRT(String number, String expectedAnswer) throws DivisionByZeroException, NegativeSqrtException {
        assertEquals(expectedAnswer, testModel.calculate(new BigDecimal(number), UnaryOperations.SQRT).toString());
    }
}
