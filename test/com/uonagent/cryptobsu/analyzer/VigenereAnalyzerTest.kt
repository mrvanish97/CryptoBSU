package com.uonagent.cryptobsu.analyzer

import com.uonagent.cryptobsu.algorithm.Vigenere
import com.uonagent.cryptobsu.language.Russian
import org.junit.jupiter.api.Test

internal class VigenereAnalyzerTest {

    val key = "прлыаовсщркдаволбьслоурвыоимит"
    val s = "Игры различаются по содержанию характерным особенностям а также по тому какое место они занимают в жизни детей их воспитании и обучении Каждый отдельный вид игры имеет многочисленные варианты Дети очень изобретательны Они усложняют и упрощают известные игры придумывают новые правила и детали Например сюжетно ролевые игры создаются самими детьми но при некотором руководстве воспитателя Их основой является самодеятельность Такие игры иногда называют творческими сюжетно ролевыми играми Разновидностью сюжетно ролевой игры являются строительные игры и игры драматизации В практике воспитания нашли своё место и игры с правилами которые создаются для детей взрослыми К ним относятся дидактические подвижные и игры забавы В основе их лежит четко определённое программное содержание дидактические задачи и целенаправленное обучение. Для хорошо организованной жизни детей в детском саду необходимо разнообразие игр так как только при этих условиях будет обеспечена детям возможность интересной и содержательной деятельности Многообразие типов видов форм игр неизбежно как неизбежно многообразие жизни которую они отражают как неизбежно многообразие несмотря на внешнюю схожесть игр одного типа модели"

    val v = Vigenere(key, Russian)

    val cipher = v.encrypt(s)
    val orig = v.decrypt(cipher)

    val kekek = "Vsppa kzcyk ocnyb wge oood, gmyggmdirff cnstgdqkxq ijth. Uon er lfee dypawu. Cewnpbfscwc gcnedtye geoviptgseo gmxaqny. Irtoo kvmofsv wypcdhko cgcwstscusp. Ggn zpynstkd tflfgdbe swhtsmmcd. Acomillg vsxggoipd vszzfvsc iplh, sesw cwsooxxsx zgy qvygwfk fsjfhrkd. Wco sw vsfccc rebyq. Asnvorrpgseo zcdhklepsx qqxnmkpbvew pgrink, sh kzzgcdmc xoixk zmwivzkx crsv. Fszyxiu kbgs oik, lvelowv xog lfbe coh, rparec gmyuwo xyjwo. Uon tjlqgbkx qth cwox qldkox er dcnvsggeifsx. Tplsuoxx qpa vovpsd, aqvowrts gd weqdo kn, msldsedoxsc dqceipp zgy. Zijwspdowofs wd kvaf achsqsd, jwvzyrlhg dopjfg wd, veatbkk xyjwo. Cvsusla oyviqewg nsgrfa gbyw, ce hgwzyq wsedew qzrcvow qpr. Pkw ieph nslipz sw devntg kkmyjtg cemxmc.\n" +
            "\n" +
            "Acomillg rboxgfa gbkx y pgv evxptqkoc tmchc. Mbeq qsnsc ilta, hoekglh wd zypfg pyx, jyfqklew nzgwobi scbc. Wkiapbcc pvgyukvve swhtsmiq ywus ox btqvew. Hmyse od qydgc km rsyq gvomdpbf wkxrtg. Eebezthwb oygdaqn, ayyx jkdki cwskporb afgdsyk, pfqc vim qoesvmqtg fskq, go djkbirco vebtgd sud cmr lagd dypawu. Nyrcn iv xousp wf kbgs qwpslyq qfkxqmjwo c sx sbtc. Pevpyx indbmatsu wypcdhko vsppa, gd ceethvsc usla dsliloio zrepphtk. Cib owedeq ce ggw fmrls xkbmsd. Jgcdmzfzww xmqw otme, ijpwhoxh ofwu cktgpb gqox, yfqvyb fgmspneq ltpj. Mevymwveb xcxdwc centsp sx ipzg xoxillhkc zspeo. Kx kg glqwvsw tpzkd. Xyln tgvsw ci, qwbcyq yse nypmc snowileio, wypjtg xormafzc fopge. Bwxm ilta fyvsp, oorslyq gwvko hgrbkccmk fh, cemxmc siod rgdw. Gdsek ncpnsqcyhww wirfg xsdec xoixk myninsc psnhwc.\n" +
            "\n" +
            "Zvmtb hobqcyhww ayyx ewsc wyrwvdsw azbuomxceit. Xkq yfqvyb zcwwv kd hyawdec tflfgdbe. Tpgvslyjfa cemxmc itxk jcwwu, opjgnwveb tflfgdbe kt zcmsrgl o. Rovpcyhgcayc zrky tyqec, oyviqewg lsfcyrww wescwu ed, jgywdec ijpwhoxh cccu. Nemq mwdoxhsx bwvve ce djkbirco gqowrlg. Uectcyrkcci tpzkd owr, acueovc ph geswkzr gppmathwb, nmaeio xyr hfgvy. Oxgla gcd ypyo, gppmathwb kx ltpj fop, nzfvdsxmc jqvexnlh vebtgd. Ewscusp otme ypyo, wvdvgnsu km pyniu sx, pyzfgod psnhwc dspect. Odmyx oe woxsd ewsc rcbig myrqpqvodyp mzcxnmr.\n" +
            "\n" +
            "Nfcc stqfa pscm, ztpgxnyk yse wkkll siod, gmyggaeer acueovc pfqc. Xek dsf ynmm ycp zevsd aqvvmq diumstge. Djkcijwiu bexpfa usd ekph ceqyc gsn zbirtio. Nyrcn qqxnmkpbvew tflfgdbe tpzkd okce gqvvmathwnsr. Qpr okviqfofk cgcwstscusp opdo qywsuekhy lqeewwyy. Gwczilowuco tpphkew pcnhwc nmyx, ov kvmofsv nem rcwudsusp o. Hecgc bicw owr, esozew lpq hoekglh wd, byrcio oqir wsq. Sxxcrst xyr azbxkvpgd zcmew, se snosjcyr cxdi. Tpgvslyjfa wd cik dsf coq swzcwmspast vksppsv fop lpq nybik. Yoo zveapfcd zypfg xovmr, l rkmdyk pgv bexpfa wd. Zvypggxd wmoonoc, pgmsty xsl ncpqei mcbcbo, iplh os cyqnwrsd qg, ph geswkzr tscyq xouck ir wctow. Jsdqg oqir fzvbsggpg vybxmc. Qwbkfgeit kd pcnhwc oy cywo ovikpbvew xgyqknerr qwpslyq azcmovye opdo. Tplsuoxx pscpmew dpzkc wescwu, ed qmwzkc krrp invkqazfrob wco. Rqxog qpr tscyq gwvko pmcso zbirtio evxptqgc. Myplpkdev fpbfbovge rws cib gsjsmyjl jwvzyrlhg.\n" +
            "\n" +
            "Cewnpbfscwc acvoxxg. Yipm xia fzvbsggpg fskq. Se sw qbettrc ynmm. Lspokr tpz pevpy azcmovye, qqxfejwwu dyvrzf xsdec, asnvorrpgseo jcwwu. Kvmofoo lsfcyrww nyg dcfkviq xsvec lcyrtobmr, lh rvkgccov vsfccc cmmykdop. Fowrtpwveq cfwuwyh gxdgbnmce aqvowrts. Rbkiqpbv myrefs ceqyc tr nslipz gqvvmathwnsr, se acvowslrc ovmr qfkxqmjwo. Coxiyy wcmepgd ewkw yr eitzsw rtbesnyle, siod zswdwdkxc dorsor rparyb.\n" +
            "\n" +
            "Ecyscx fmrls xormafzc nem, lpq cvsusph pscp. Qpr eyxwcnhgdev bldklew jzfgw, k spyoto tyqec xocxgminew mb. Yoo rorbcstsd wcx o noy istgoyn."

    @Test
    fun hack() {
        val h = VigenereAnalyzer(Russian)
        val s = h.hack(cipher)
        s.forEach { println("$it\n") }
        println(s.size)
    }
}