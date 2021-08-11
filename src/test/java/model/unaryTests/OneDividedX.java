package model.unaryTests;

import model.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OneDividedX {
    Calculator testModel = new Calculator();

    @Test
    public void oneDividedXScenarios() throws DivisionByZeroException, NegativeSqrtException{
        assertOneDividedX("1", "1");
        assertOneDividedX("2", "0.5");
        assertOneDividedX("3", "0.3333333333333333333333333333333333");
        assertOneDividedX("4", "0.25");
        assertOneDividedX("5", "0.2");
        assertOneDividedX("6", "0.1666666666666666666666666666666667");
        assertOneDividedX("7", "0.1428571428571428571428571428571429");
        assertOneDividedX("8", "0.125");
        assertOneDividedX("9", "0.1111111111111111111111111111111111");
        assertOneDividedX("10", "0.1");
        assertOneDividedX("11", "0.09090909090909090909090909090909091");
        assertOneDividedX("14", "0.07142857142857142857142857142857143");
        assertOneDividedX("19", "0.05263157894736842105263157894736842");
        assertOneDividedX("20", "0.05");
        assertOneDividedX("21", "0.04761904761904761904761904761904762");
        assertOneDividedX("26", "0.03846153846153846153846153846153846");
        assertOneDividedX("29", "0.03448275862068965517241379310344828");
        assertOneDividedX("30", "0.03333333333333333333333333333333333");
        assertOneDividedX("31", "0.03225806451612903225806451612903226");
        assertOneDividedX("33", "0.03030303030303030303030303030303030");
        assertOneDividedX("38", "0.02631578947368421052631578947368421");
        assertOneDividedX("43", "0.02325581395348837209302325581395349");
        assertOneDividedX("44", "0.02272727272727272727272727272727273");
        assertOneDividedX("49", "0.02040816326530612244897959183673469");
        assertOneDividedX("50", "0.02");
        assertOneDividedX("51", "0.01960784313725490196078431372549020");
        assertOneDividedX("54", "0.01851851851851851851851851851851852");
        assertOneDividedX("55", "0.01818181818181818181818181818181818");
        assertOneDividedX("62", "0.01612903225806451612903225806451613");
        assertOneDividedX("65", "0.01538461538461538461538461538461538");
        assertOneDividedX("66", "0.01515151515151515151515151515151515");
        assertOneDividedX("74", "0.01351351351351351351351351351351351");
        assertOneDividedX("76", "0.01315789473684210526315789473684211");
        assertOneDividedX("77", "0.01298701298701298701298701298701299");
        assertOneDividedX("86", "0.01162790697674418604651162790697674");
        assertOneDividedX("87", "0.01149425287356321839080459770114943");
        assertOneDividedX("88", "0.01136363636363636363636363636363636");
        assertOneDividedX("98", "0.01020408163265306122448979591836735");
        assertOneDividedX("99", "0.01010101010101010101010101010101010");
        assertOneDividedX("100", "0.01");
        assertOneDividedX("101", "0.009900990099009900990099009900990099");
        assertOneDividedX("108", "0.009259259259259259259259259259259259");
        assertOneDividedX("111", "0.009009009009009009009009009009009009");
        assertOneDividedX("129", "0.007751937984496124031007751937984496");
        assertOneDividedX("138", "0.007246376811594202898550724637681159");
        assertOneDividedX("145", "0.006896551724137931034482758620689655");
        assertOneDividedX("152", "0.006578947368421052631578947368421053");
        assertOneDividedX("161", "0.006211180124223602484472049689440994");
        assertOneDividedX("171", "0.005847953216374269005847953216374269");
        assertOneDividedX("185", "0.005405405405405405405405405405405405");
        assertOneDividedX("197", "0.005076142131979695431472081218274112");
        assertOneDividedX("210", "0.004761904761904761904761904761904762");
        assertOneDividedX("211", "0.004739336492890995260663507109004739");
        assertOneDividedX("214", "0.004672897196261682242990654205607477");
        assertOneDividedX("222", "0.004504504504504504504504504504504505");
        assertOneDividedX("226", "0.004424778761061946902654867256637168");
        assertOneDividedX("237", "0.004219409282700421940928270042194093");
        assertOneDividedX("244", "0.004098360655737704918032786885245902");
        assertOneDividedX("253", "0.003952569169960474308300395256916996");
        assertOneDividedX("260", "0.003846153846153846153846153846153846");
        assertOneDividedX("278", "0.003597122302158273381294964028776978");
        assertOneDividedX("286", "0.003496503496503496503496503496503497");
        assertOneDividedX("301", "0.003322259136212624584717607973421927");
        assertOneDividedX("314", "0.003184713375796178343949044585987261");
        assertOneDividedX("322", "0.003105590062111801242236024844720497");
        assertOneDividedX("328", "0.003048780487804878048780487804878049");
        assertOneDividedX("331", "0.003021148036253776435045317220543807");
        assertOneDividedX("333", "0.003003003003003003003003003003003003");
        assertOneDividedX("348", "0.002873563218390804597701149425287356");
        assertOneDividedX("356", "0.002808988764044943820224719101123596");
        assertOneDividedX("367", "0.002724795640326975476839237057220708");
        assertOneDividedX("376", "0.002659574468085106382978723404255319");
        assertOneDividedX("389", "0.002570694087403598971722365038560411");
        assertOneDividedX("403", "0.002481389578163771712158808933002481");
        assertOneDividedX("418", "0.002392344497607655502392344497607656");
        assertOneDividedX("428", "0.002336448598130841121495327102803738");
        assertOneDividedX("431", "0.002320185614849187935034802784222738");
        assertOneDividedX("433", "0.002309468822170900692840646651270208");
        assertOneDividedX("444", "0.002252252252252252252252252252252252");
        assertOneDividedX("449", "0.002227171492204899777282850779510022");
        assertOneDividedX("453", "0.002207505518763796909492273730684327");
        assertOneDividedX("467", "0.002141327623126338329764453961456103");
        assertOneDividedX("479", "0.002087682672233820459290187891440501");
        assertOneDividedX("492", "0.002032520325203252032520325203252033");
        assertOneDividedX("512", "0.001953125");
        assertOneDividedX("524", "0.001908396946564885496183206106870229");
        assertOneDividedX("539", "0.001855287569573283858998144712430427");
        assertOneDividedX("544", "0.001838235294117647058823529411764706");
        assertOneDividedX("547", "0.001828153564899451553930530164533821");
        assertOneDividedX("553", "0.001808318264014466546112115732368897");
        assertOneDividedX("555", "0.001801801801801801801801801801801802");
        assertOneDividedX("562", "0.001779359430604982206405693950177936");
        assertOneDividedX("570", "0.001754385964912280701754385964912281");
        assertOneDividedX("574", "0.001742160278745644599303135888501742");
        assertOneDividedX("582", "0.001718213058419243986254295532646048");
        assertOneDividedX("586", "0.001706484641638225255972696245733788");
        assertOneDividedX("599", "0.001669449081803005008347245409015025");
        assertOneDividedX("612", "0.001633986928104575163398692810457516");
        assertOneDividedX("614", "0.001628664495114006514657980456026059");
        assertOneDividedX("628", "0.001592356687898089171974522292993631");
        assertOneDividedX("638", "0.001567398119122257053291536050156740");
        assertOneDividedX("642", "0.001557632398753894080996884735202492");
        assertOneDividedX("655", "0.001526717557251908396946564885496183");
        assertOneDividedX("657", "0.001522070015220700152207001522070015");
        assertOneDividedX("661", "0.001512859304084720121028744326777610");
        assertOneDividedX("666", "0.001501501501501501501501501501501502");
        assertOneDividedX("679", "0.001472754050073637702503681885125184");
        assertOneDividedX("683", "0.001464128843338213762811127379209370");
        assertOneDividedX("690", "0.001449275362318840579710144927536232");
        assertOneDividedX("704", "0.001420454545454545454545454545454545");
        assertOneDividedX("718", "0.001392757660167130919220055710306407");
        assertOneDividedX("721", "0.001386962552011095700416088765603329");
        assertOneDividedX("739", "0.001353179972936400541271989174560217");
        assertOneDividedX("742", "0.001347708894878706199460916442048518");
        assertOneDividedX("756", "0.001322751322751322751322751322751323");
        assertOneDividedX("763", "0.001310615989515072083879423328964613");
        assertOneDividedX("766", "0.001305483028720626631853785900783290");
        assertOneDividedX("777", "0.001287001287001287001287001287001287");
        assertOneDividedX("785", "0.001273885350318471337579617834394904");
        assertOneDividedX("812", "0.001231527093596059113300492610837438");
        assertOneDividedX("824", "0.001213592233009708737864077669902913");
        assertOneDividedX("831", "0.001203369434416365824308062575210590");
        assertOneDividedX("847", "0.001180637544273907910271546635182999");
        assertOneDividedX("856", "0.001168224299065420560747663551401869");
        assertOneDividedX("862", "0.001160092807424593967517401392111369");
        assertOneDividedX("877", "0.001140250855188141391106043329532497");
        assertOneDividedX("879", "0.001137656427758816837315130830489192");
        assertOneDividedX("882", "0.001133786848072562358276643990929705");
        assertOneDividedX("888", "0.001126126126126126126126126126126126");
        assertOneDividedX("893", "0.001119820828667413213885778275475924");
        assertOneDividedX("905", "0.001104972375690607734806629834254144");
        assertOneDividedX("914", "0.001094091903719912472647702407002188");
        assertOneDividedX("927", "0.001078748651564185544768069039913700");
        assertOneDividedX("935", "0.001069518716577540106951871657754011");
        assertOneDividedX("946", "0.001057082452431289640591966173361522");
        assertOneDividedX("952", "0.001050420168067226890756302521008403");
        assertOneDividedX("963", "0.001038421599169262720664589823468328");
        assertOneDividedX("977", "0.001023541453428863868986693961105425");
        assertOneDividedX("986", "0.001014198782961460446247464503042596");
        assertOneDividedX("988", "0.001012145748987854251012145748987854");
        assertOneDividedX("999", "0.001001001001001001001001001001001001");
        assertOneDividedX("1000", "0.001");
        assertOneDividedX("1001", "0.0009990009990009990009990009990009990");
        assertOneDividedX("1008", "0.0009920634920634920634920634920634921");
        assertOneDividedX("1111", "0.0009000900090009000900090009000900090");
        assertOneDividedX("1114", "0.0008976660682226211849192100538599641");
        assertOneDividedX("1226", "0.0008156606851549755301794453507340946");
        assertOneDividedX("1314", "0.0007610350076103500761035007610350076");
        assertOneDividedX("1403", "0.0007127583749109052031361368496079829");
        assertOneDividedX("1524", "0.0006561679790026246719160104986876640");
        assertOneDividedX("1628", "0.0006142506142506142506142506142506143");
        assertOneDividedX("1718", "0.0005820721769499417927823050058207218");
        assertOneDividedX("1812", "0.0005518763796909492273730684326710817");
        assertOneDividedX("1905", "0.0005249343832020997375328083989501312");
        assertOneDividedX("2013", "0.0004967709885742672627918529557873820");
        assertOneDividedX("2175", "0.0004597701149425287356321839080459770");
        assertOneDividedX("2112", "0.0004734848484848484848484848484848485");
        assertOneDividedX("2222", "0.0004500450045004500450045004500450045");
        assertOneDividedX("2256", "0.0004432624113475177304964539007092199");
        assertOneDividedX("2367", "0.0004224757076468103084072665821715251");
        assertOneDividedX("2498", "0.0004003202562049639711769415532425941");
        assertOneDividedX("2596", "0.0003852080123266563944530046224961479");
        assertOneDividedX("2696", "0.0003709198813056379821958456973293769");
        assertOneDividedX("2731", "0.0003661662394727206151592823141706335");
        assertOneDividedX("2891", "0.0003459010722933241093047388446904185");
        assertOneDividedX("2964", "0.0003373819163292847503373819163292848");
        assertOneDividedX("3015", "0.0003316749585406301824212271973466003");
        assertOneDividedX("3173", "0.0003151591553734635991175543649543019");
        assertOneDividedX("3224", "0.0003101736972704714640198511166253102");
        assertOneDividedX("3265", "0.0003062787136294027565084226646248086");
        assertOneDividedX("3324", "0.0003008423586040914560770156438026474");
        assertOneDividedX("3333", "0.0003000300030003000300030003000300030");
        assertOneDividedX("3477", "0.0002876042565429968363531780270348001");
        assertOneDividedX("3531", "0.0002832058906825261965448881336731804");
        assertOneDividedX("3647", "0.0002741979709350150808884014258294489");
        assertOneDividedX("3787", "0.0002640612622128333773435437021388962");
        assertOneDividedX("3889", "0.0002571355104139881717665209565440987");
        assertOneDividedX("3932", "0.0002543234994913530010172939979654120");
        assertOneDividedX("4077", "0.0002452783909737552121658081922982585");
        assertOneDividedX("4178", "0.0002393489707994255624700813786500718");
        assertOneDividedX("4222", "0.0002368545712932259592610137375651350");
        assertOneDividedX("4336", "0.0002306273062730627306273062730627306");
        assertOneDividedX("4378", "0.0002284148012791228871630881681132937");
        assertOneDividedX("4425", "0.0002259887005649717514124293785310734");
        assertOneDividedX("4444", "0.0002250225022502250225022502250225023");
        assertOneDividedX("4554", "0.0002195871761089152393500219587176109");
        assertOneDividedX("4647", "0.0002151925973746503120292661932429524");
        assertOneDividedX("4781", "0.0002091612633340305375444467684584815");
        assertOneDividedX("4856", "0.0002059308072487644151565074135090610");
        assertOneDividedX("4986", "0.0002005615724027276373846770958684316");
        assertOneDividedX("5086", "0.0001966181675186787259142744789618561");
        assertOneDividedX("5154", "0.0001940240589833139309274350019402406");
        assertOneDividedX("5243", "0.0001907304978065992752241083349227541");
        assertOneDividedX("5323", "0.0001878639864737929738869058801427766");
        assertOneDividedX("5416", "0.0001846381093057607090103397341211226");
        assertOneDividedX("5448", "0.0001835535976505139500734214390602056");
        assertOneDividedX("5555", "0.0001800180018001800180018001800180018");
        assertOneDividedX("5570", "0.0001795332136445242369838420107719928");
        assertOneDividedX("5631", "0.0001775883502042266027348605931450897");
        assertOneDividedX("5960", "0.0001677852348993288590604026845637584");
        assertOneDividedX("6036", "0.0001656726308813783962889330682571239");
        assertOneDividedX("6271", "0.0001594642002870355605166640089299952");
        assertOneDividedX("6354", "0.0001573811772112055398174378344350016");
        assertOneDividedX("6429", "0.0001555451858764971224140612848032353");
        assertOneDividedX("6519", "0.0001533977603926982666053075625095874");
        assertOneDividedX("6560", "0.0001524390243902439024390243902439024");
        assertOneDividedX("6666", "0.0001500150015001500150015001500150015");
        assertOneDividedX("6667", "0.0001499925003749812509374531273436328");
        assertOneDividedX("6753", "0.0001480823337775803346660743373315563");
        assertOneDividedX("6874", "0.0001454757055571719522839685772475997");
        assertOneDividedX("6950", "0.0001438848920863309352517985611510791");
        assertOneDividedX("7071", "0.0001414227124876255126573327676424834");
        assertOneDividedX("7118", "0.0001404889013767912334925540882270301");
        assertOneDividedX("7224", "0.0001384274640088593576965669988925803");
        assertOneDividedX("7335", "0.0001363326516700749829584185412406271");
        assertOneDividedX("7452", "0.0001341921631776704240472356414385400");
        assertOneDividedX("7589", "0.0001317696666227434444590855185136382");
        assertOneDividedX("7672", "0.0001303441084462982273201251303441084");
        assertOneDividedX("7765", "0.0001287830006439150032195750160978751");
        assertOneDividedX("7777", "0.0001285842870001285842870001285842870");
        assertOneDividedX("7850", "0.0001273885350318471337579617834394904");
        assertOneDividedX("7919", "0.0001262785705265816390958454350296755");
        assertOneDividedX("8072", "0.0001238850346878097125867195242814668");
        assertOneDividedX("8146", "0.0001227596366314755708323103363614044");
        assertOneDividedX("8230", "0.0001215066828675577156743620899149453");
        assertOneDividedX("8336", "0.0001199616122840690978886756238003839");
        assertOneDividedX("8419", "0.0001187789523696400997743199904976838");
        assertOneDividedX("8591", "0.0001164008846467233150971947386800140");
        assertOneDividedX("8636", "0.0001157943492357572950440018527095878");
        assertOneDividedX("8745", "0.0001143510577472841623785020011435106");
        assertOneDividedX("8784", "0.0001138433515482695810564663023679417");
        assertOneDividedX("8855", "0.0001129305477131564088085827216261999");
        assertOneDividedX("8888", "0.0001125112511251125112511251125112511");
        assertOneDividedX("8958", "0.0001116320607278410359455235543648136");
        assertOneDividedX("9083", "0.0001100957833314984036111416932731476");
        assertOneDividedX("9112", "0.0001097453906935908691834942932396839");
        assertOneDividedX("9214", "0.0001085304970696765791187323637942262");
        assertOneDividedX("9335", "0.0001071237279057311194429566148901982");
        assertOneDividedX("9487", "0.0001054073995994518815220828502160852");
        assertOneDividedX("9522", "0.0001050199537912203318630539802562487");
        assertOneDividedX("9672", "0.0001033912324234904880066170388751034");
        assertOneDividedX("9755", "0.0001025115325474115838031778575089698");
        assertOneDividedX("9826", "0.0001017708121310808060248320781599837");
        assertOneDividedX("9989", "0.0001001101211332465712283511863049354");
        assertOneDividedX("9896", "0.0001010509296685529506871463217461601");
        assertOneDividedX("10000", "0.0001");
        assertOneDividedX("55555", "0.00001800018000180001800018000180001800");
        assertOneDividedX("82534", "0.00001211621877044611917512782610802821");
        assertOneDividedX("437903", "0.000002283610753979762641498231343471043");
        assertOneDividedX("840736", "0.000001189434019716058310813382560042629");
        assertOneDividedX("2234567", "4.475139926437649889217911121035977E-7");
        assertOneDividedX("4534074", "2.205522009565790059888744647749463E-7");
        assertOneDividedX("49771169", "2.009195323501443174862941234110856E-8");
        assertOneDividedX("72324911", "1.382649471908786724950135092457978E-8");
        assertOneDividedX("659254843", "1.516864093784139254324749799373108E-9");
        assertOneDividedX("888888888", "1.125000001125000001125000001125000E-9");
        assertOneDividedX("1874764566", "5.334003096365327826448795811089594E-10");
        assertOneDividedX("6243776665", "1.601594761717826433498802923630837E-10");
        assertOneDividedX("47037036736", "2.125984265574803236686614730542366E-11");
        assertOneDividedX("444444444444", "2.250000000002250000000002250000000E-12");
        assertOneDividedX("1000000000000", "1E-12");
        assertOneDividedX("6578868631288", "1.520018191644938891135954892629751E-13");
        assertOneDividedX("8407407347404", "1.189427321264236509963081303520301E-13");
        assertOneDividedX("34691357824690", "2.882562294198514678956690261819597E-14");
        assertOneDividedX("96419752386415", "1.037131889731853705963335709577200E-14");
        assertOneDividedX("109975967636925", "9.092895670637816942123440879933590E-15");
        assertOneDividedX("565933996761014", "1.766990507238048102918249252878902E-15");
        assertOneDividedX("1000000000000000", "1E-15");
        assertOneDividedX("1082424349226241", "9.238520924948139528057501194508645E-16");
        assertOneDividedX("1028962228779747", "9.718529718879054525695586437748659E-16");
        assertOneDividedX("10000000000000000", "1E-16");
        assertOneDividedX("1E+18", "1E-18");
        assertOneDividedX("5.647753E+23", "1.770615676712490790585211499157275E-24");
        assertOneDividedX("8.8788779E+24", "1.126268444349257241165575663564424E-25");
        assertOneDividedX("9.86859867454E+38", "1.013315094654624299385761289732197E-39");
        assertOneDividedX("1E+296", "1E-296");
        assertOneDividedX("5.647753E+549", "1.770615676712490790585211499157275E-550");
        assertOneDividedX("8.8788779E+897", "1.126268444349257241165575663564424E-898");
        assertOneDividedX("9.86859867454E+978", "1.013315094654624299385761289732197E-979");
        assertOneDividedX("1E+1295", "1E-1295");
        assertOneDividedX("1E+1296", "1E-1296");
        assertOneDividedX("1E+1297", "1E-1297");
        assertOneDividedX("5.647753E+1549", "1.770615676712490790585211499157275E-1550");
        assertOneDividedX("8.8788779E+1897", "1.126268444349257241165575663564424E-1898");
        assertOneDividedX("9.86859867454E+1978", "1.013315094654624299385761289732197E-1979");
        assertOneDividedX("1E+2295", "1E-2295");
        assertOneDividedX("1E+2296", "1E-2296");
        assertOneDividedX("1E+2297", "1E-2297");
        assertOneDividedX("5.647753E+2549", "1.770615676712490790585211499157275E-2550");
        assertOneDividedX("8.8788779E+2897", "1.126268444349257241165575663564424E-2898");
        assertOneDividedX("9.86859867454E+2978", "1.013315094654624299385761289732197E-2979");
        assertOneDividedX("1E+3295", "1E-3295");
        assertOneDividedX("1E+3296", "1E-3296");
        assertOneDividedX("1E+3297", "1E-3297");
        assertOneDividedX("8.8788779E+3897", "1.126268444349257241165575663564424E-3898");
        assertOneDividedX("9.86859867454E+3978", "1.013315094654624299385761289732197E-3979");
        assertOneDividedX("1E+4295", "1E-4295");
        assertOneDividedX("1E+4296", "1E-4296");
        assertOneDividedX("1E+4297", "1E-4297");
        assertOneDividedX("5.647753E+4549", "1.770615676712490790585211499157275E-4550");
        assertOneDividedX("8.8788779E+4897", "1.126268444349257241165575663564424E-4898");
        assertOneDividedX("9.86859867454E+4978", "1.013315094654624299385761289732197E-4979");
        assertOneDividedX("1E+5295", "1E-5295");
        assertOneDividedX("1E+5296", "1E-5296");
        assertOneDividedX("1E+5297", "1E-5297");
        assertOneDividedX("5.647753E+5549", "1.770615676712490790585211499157275E-5550");
        assertOneDividedX("8.8788779E+5897", "1.126268444349257241165575663564424E-5898");
        assertOneDividedX("9.86859867454E+5978", "1.013315094654624299385761289732197E-5979");
        assertOneDividedX("1E+6295", "1E-6295");
        assertOneDividedX("1E+6296", "1E-6296");
        assertOneDividedX("1E+6297", "1E-6297");
        assertOneDividedX("5.647753E+6549", "1.770615676712490790585211499157275E-6550");
        assertOneDividedX("8.8788779E+6897", "1.126268444349257241165575663564424E-6898");
        assertOneDividedX("9.86859867454E+6978", "1.013315094654624299385761289732197E-6979");
        assertOneDividedX("1E+7295", "1E-7295");
        assertOneDividedX("1E+7296", "1E-7296");
        assertOneDividedX("1E+7297", "1E-7297");
        assertOneDividedX("5.647753E+7549", "1.770615676712490790585211499157275E-7550");
        assertOneDividedX("8.8788779E+7897", "1.126268444349257241165575663564424E-7898");
        assertOneDividedX("9.86859867454E+7978", "1.013315094654624299385761289732197E-7979");
        assertOneDividedX("1E+8295", "1E-8295");
        assertOneDividedX("1E+8296", "1E-8296");
        assertOneDividedX("1E+8297", "1E-8297");
        assertOneDividedX("5.647753E+8549", "1.770615676712490790585211499157275E-8550");
        assertOneDividedX("8.8788779E+8897", "1.126268444349257241165575663564424E-8898");
        assertOneDividedX("9.86859867454E+8978", "1.013315094654624299385761289732197E-8979");
        assertOneDividedX("1E+9295", "1E-9295");
        assertOneDividedX("1E+9296", "1E-9296");
        assertOneDividedX("1E+9297", "1E-9297");
        assertOneDividedX("5.647753E+9549", "1.770615676712490790585211499157275E-9550");
        assertOneDividedX("8.8788779E+9897", "1.126268444349257241165575663564424E-9898");
        assertOneDividedX("9.86859867454E+9978", "1.013315094654624299385761289732197E-9979");
        assertOneDividedX("1E+10295", "1E-10295");
        assertOneDividedX("1E+10296", "1E-10296");
        assertOneDividedX("1E+10297", "1E-10297");
        assertOneDividedX("5.647753E+10549", "1.770615676712490790585211499157275E-10550");
        assertOneDividedX("8.8788779E+10897", "1.126268444349257241165575663564424E-10898");
        assertOneDividedX("9.86859867454E+10978", "1.013315094654624299385761289732197E-10979");
        assertOneDividedX("9999999999999999E9999", "1.000000000000000100000000000000010E-10015");

        assertOneDividedX("0.001", "1E+3");
        assertOneDividedX("0.002", "5E+2");
        assertOneDividedX("0.003", "333.3333333333333333333333333333333");
        assertOneDividedX("0.004", "2.5E+2");
        assertOneDividedX("0.004", "2.5E+2");
        assertOneDividedX("0.005", "2E+2");
        assertOneDividedX("0.006", "166.6666666666666666666666666666667");
        assertOneDividedX("0.007", "142.8571428571428571428571428571429");
        assertOneDividedX("0.008", "125");
        assertOneDividedX("0.009", "111.1111111111111111111111111111111");
        assertOneDividedX("0.010", "1E+2");
        assertOneDividedX("0.00011", "9090.909090909090909090909090909091");
        assertOneDividedX("0.00043", "2325.581395348837209302325581395349");
        assertOneDividedX("0.00098", "1020.408163265306122448979591836735");
        assertOneDividedX("0.00152", "657.8947368421052631578947368421053");
        assertOneDividedX("0.00278", "359.7122302158273381294964028776978");
        assertOneDividedX("0.00367", "272.4795640326975476839237057220708");
        assertOneDividedX("0.00547", "182.8153564899451553930530164533821");
        assertOneDividedX("0.00562", "177.9359430604982206405693950177936");
        assertOneDividedX("0.00679", "147.2754050073637702503681885125184");
        assertOneDividedX("0.00742", "134.7708894878706199460916442048518");
        assertOneDividedX("0.00893", "111.9820828667413213885778275475924");
        assertOneDividedX("0.00935", "106.9518716577540106951871657754011");
        assertOneDividedX("0.00952", "105.0420168067226890756302521008403");
        assertOneDividedX("0.00999", "100.1001001001001001001001001001001");
        assertOneDividedX("0.01001", "99.90009990009990009990009990009990");
        assertOneDividedX("0.000001008", "992063.4920634920634920634920634921");
        assertOneDividedX("0.000002256", "443262.4113475177304964539007092199");
        assertOneDividedX("0.000003173", "315159.1553734635991175543649543019");
        assertOneDividedX("0.000003477", "287604.2565429968363531780270348001");
        assertOneDividedX("0.000003889", "257135.5104139881717665209565440987");
        assertOneDividedX("0.000004378", "228414.8012791228871630881681132937");
        assertOneDividedX("0.000004647", "215192.5973746503120292661932429524");
        assertOneDividedX("0.000005448", "183553.5976505139500734214390602056");
        assertOneDividedX("0.000006271", "159464.2002870355605166640089299952");
        assertOneDividedX("0.000007118", "140488.9013767912334925540882270301");
        assertOneDividedX("0.000008072", "123885.0346878097125867195242814668");
        assertOneDividedX("0.000009112", "109745.3906935908691834942932396839");
        assertOneDividedX("0.000009214", "108530.4970696765791187323637942262");
        assertOneDividedX("0.000009999", "100010.0010001000100010001000100010");
        assertOneDividedX("0.00001", "1E+5");
        assertOneDividedX("0.000010001", "99990.00099990000999900009999000100");
        assertOneDividedX("0.000055555", "18000.18000180001800018000180001800");
        assertOneDividedX("0.000082534", "12116.21877044611917512782610802821");
        assertOneDividedX("0.072324911", "13.82649471908786724950135092457978");
        assertOneDividedX("1E-18", "1E+18");
        assertOneDividedX("5.647753E-11", "17706156767.12490790585211499157275");
        assertOneDividedX("8.8788779E-10", "1126268444.349257241165575663564424");
        assertOneDividedX("9.86859867454E-16", "1013315094654624.299385761289732197");
        assertOneDividedX("1E-296", "1E+296");
        assertOneDividedX("5.647753E-537", "1.770615676712490790585211499157275E+536");
        assertOneDividedX("8.8788779E-883", "1.126268444349257241165575663564424E+882");
        assertOneDividedX("9.86859867454E-956", "1.013315094654624299385761289732197E+955");
        assertOneDividedX("1E-1296", "1E+1296");
        assertOneDividedX("5.647753E-1537", "1.770615676712490790585211499157275E+1536");
        assertOneDividedX("8.8788779E-1883", "1.126268444349257241165575663564424E+1882");
        assertOneDividedX("9.86859867454E-1956", "1.013315094654624299385761289732197E+1955");
        assertOneDividedX("1E-2296", "1E+2296");
        assertOneDividedX("5.647753E-2537", "1.770615676712490790585211499157275E+2536");
        assertOneDividedX("8.8788779E-2883", "1.126268444349257241165575663564424E+2882");
        assertOneDividedX("9.86859867454E-2956", "1.013315094654624299385761289732197E+2955");
        assertOneDividedX("1E-3296", "1E+3296");
        assertOneDividedX("5.647753E-3537", "1.770615676712490790585211499157275E+3536");
        assertOneDividedX("8.8788779E-3883", "1.126268444349257241165575663564424E+3882");
        assertOneDividedX("9.86859867454E-3956", "1.013315094654624299385761289732197E+3955");
        assertOneDividedX("1E-4296", "1E+4296");
        assertOneDividedX("5.647753E-4537", "1.770615676712490790585211499157275E+4536");
        assertOneDividedX("8.8788779E-4883", "1.126268444349257241165575663564424E+4882");
        assertOneDividedX("9.86859867454E-4956", "1.013315094654624299385761289732197E+4955");
        assertOneDividedX("1E-5296", "1E+5296");
        assertOneDividedX("5.647753E-5537", "1.770615676712490790585211499157275E+5536");
        assertOneDividedX("8.8788779E-5883", "1.126268444349257241165575663564424E+5882");
        assertOneDividedX("9.86859867454E-5956", "1.013315094654624299385761289732197E+5955");
        assertOneDividedX("1E-6296", "1E+6296");
        assertOneDividedX("5.647753E-6537", "1.770615676712490790585211499157275E+6536");
        assertOneDividedX("8.8788779E-6883", "1.126268444349257241165575663564424E+6882");
        assertOneDividedX("9.86859867454E-6956", "1.013315094654624299385761289732197E+6955");
        assertOneDividedX("1E-7296", "1E+7296");
        assertOneDividedX("5.647753E-7537", "1.770615676712490790585211499157275E+7536");
        assertOneDividedX("8.8788779E-7883", "1.126268444349257241165575663564424E+7882");
        assertOneDividedX("9.86859867454E-7956", "1.013315094654624299385761289732197E+7955");
        assertOneDividedX("1E-8296", "1E+8296");
        assertOneDividedX("5.647753E-8537", "1.770615676712490790585211499157275E+8536");
        assertOneDividedX("8.8788779E-8883", "1.126268444349257241165575663564424E+8882");
        assertOneDividedX("9.86859867454E-8956", "1.013315094654624299385761289732197E+8955");
        assertOneDividedX("1E-9296", "1E+9296");
        assertOneDividedX("5.647753E-9537", "1.770615676712490790585211499157275E+9536");
        assertOneDividedX("8.8788779E-9883", "1.126268444349257241165575663564424E+9882");
        assertOneDividedX("9.86859867454E-9956", "1.013315094654624299385761289732197E+9955");
        assertOneDividedX("1E-10296", "1E+10296");
        assertOneDividedX("5.647753E-10537", "1.770615676712490790585211499157275E+10536");
        assertOneDividedX("8.8788779E-10883", "1.126268444349257241165575663564424E+10882");
        assertOneDividedX("9.86859867454E-10956", "1.013315094654624299385761289732197E+10955");
        assertOneDividedX("1E-9998", "1E+9998");
        assertOneDividedX("1E-9999", "1E+9999");
        assertOneDividedX("1E-10000", "1E+10000");
        assertOneDividedX("0.0000000000000001", "1E+16");
    }

    private void assertOneDividedX(String number, String expectedAnswer) throws DivisionByZeroException, NegativeSqrtException{
        assertEquals(expectedAnswer, testModel.calculate(new BigDecimal(number), UnaryOperations.ONE_DIVIDED_X).toString());
        assertEquals("-" + expectedAnswer, testModel.calculate(new BigDecimal("-" + number), UnaryOperations.ONE_DIVIDED_X).toString());
    }
}
