package com.astrapay.qris;

import com.astrapay.qris.mpm.QrisParser;
import com.astrapay.qris.object.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class QrisMapperTest {

  @InjectMocks
  private QrisMapper qrisMapper;

  @Test
  void mapToStringQrisWithTipPercentageTest() {
    generateQrisToString("00020101021226580006id.ovo01189360091200006049620215yq38ZDs7MI6oaz50303UKE51450015ID.OR.GPNQR.WWW0215ID10200416988350303UKE520458125303360540650000055020357030.75802ID5911Tims Donuts6013Jakarta Barat61051161062310507VCcCtqJ0716HgxK16eFVHfvKnGO6304265F");
    generateQrisToString("00020101021226580006id.ovo01189360091200006049620215yq38ZDs7MI6oaz50303UKE51450015ID.OR.GPNQR.WWW0215ID10200416988350303UKE52045812530336054065000005802ID5911Tims Donuts6013Jakarta Barat61051161062310507VCcCtqJ0716HgxK16eFVHfvKnGO63048A85");
    generateQrisToString("00020101021226580006id.ovo01189360091200006049620215yq38ZDs7MI6oaz50303UKE51450015ID.OR.GPNQR.WWW0215ID10200416988350303UKE52045812530336054061000005502015802ID5911Tims Donuts6013Jakarta Barat61051161062310507VCcCtqJ0716HgxK16eFVHfvKnGO6304E237");
    generateQrisToString("00020101021226640018ID.CO.ASTRAPAY.WWW011893600822321000045502092100004550303UBE51440014ID.CO.QRIS.WWW0215ID20210719803990303UBE520475385303360540745480515802ID5916AUTO2000 Bintaro6009Tangerang610515118626001152110050107770150715ASTRAPAY210502198180209210000455030116304E3CF");
    generateQrisToString("00020101021126570011ID.DANA.WWW011893600915300060605702090006060570303UMI51440014ID.CO.QRIS.WWW0215ID10190046990790303UMI5204481453033605802ID5912Saifullah.id6014Kota Pontianak61057812463045F72");
//    generateQrisToString("00020101021226610014COM.GO-JEK.WWW01189360091432343267810210G2343267810303UBE51440014ID.CO.QRIS.WWW0215ID20190143816000303UBE5204581253033605802ID5910Starbucks 6013JAKARTA PUSAT610510210540839000.006239502801202104130502044NMWVA6P4CID0703A0363049A04"); // error amount
    generateQrisToString("00020101021126630014ID.SPINPAY.WWW011893600816343100062402121314310006240303UMI51440014ID.CO.QRIS.WWW0215ID10200384314890303UMI5204839853033605802ID5904SPIN6013Jakarta Pusat61051034062140103***0703A0163045CDD");
    generateQrisToString("00020101021226530012COM.DOKU.WWW0118936008990000002475020424750303URE51440014ID.CO.QRIS.WWW0215ID10200392934820303URE5204539953033605404100055020256035005802ID5911GUREUM SHOP6013JAKARTA PUSAT61051064062070703A016304FD26");
    generateQrisToString("0002010102122654000200011893600014300061643802150008850006164380303UKE5204541153033605405495005802ID5913OMBE KOFIE-HO6013JAKARTA UTARA6105142406259010611093205121100131109320708AG20521199170002000107DINAMIS63049414");
// generateQrisToString("00020101021226660014ID.LINKAJA.WWW011893600911002711446402151902170711446450303UBE51450015ID.OR.GPNQR.WWW02150000000000000000303UBE520454995802ID5920SPBU SNTRA BISNIS AR6001-6101-621801143414210-7584075303360550201540630000063040FA0"); // error
    generateQrisToString("00020101021226620016COM.ASTRAPAY.WWW011893600822321000001802092100000180303UBE520450455303360540445805802ID5914Yokke Merchant6015Jakarta Selatan610512440626001152104140025420150715ASTRAPAY0000100981802092100000180301163040E7E");
    generateQrisToString("00020101021126610014COM.GO-JEK.WWW01189360091435804770920210G5804770920303URE51440014ID.CO.QRIS.WWW0215ID20200182437880303URE5204839853033605802ID5925Lazis Amalia Astra PT Int6013JAKARTA UTARA61051433062070703A946304E083");
    generateQrisToString("00020101021226630014ID.SPINPAY.WWW011893600816319100102402121314310103170303URE51430014ID.CO.QRIS.WWW0214ID1314310103170303URE520472985303360540411355802ID5908MNC LIFE6007JAKARTA61052020362390707TID00656024607cc759c07a8847bf7b4def63040741");
    generateQrisToString("00020101021126610014COM.GO-JEK.WWW01189360091430438058080210G7238689620303UMI51440014ID.CO.QRIS.WWW0215ID10190847190020303UMI5204581253033605802ID5909Bluebird36015Bandung deket r61054025762090705PT20063044CAF");
    generateQrisToString("00020101021126670018ID.CO.EXAMPLE2.WWW01159360001404567890215MIDCONTOH1234560303UMI51370014ID.CO.QRIS.WWW0215ID10191234567815204123453033605802ID5914NamaMerchantC16009NamaKota16110123456789062070703K196304B22E");
    generateQrisToString("00020101021126650013ID.CO.BCA.WWW011893600014000128766702150008850012876670303UKE51440014ID.CO.QRIS.WWW0215ID10210818616060303UKE5204074253033605802ID5909GREEN PAW6007TANGSEL61051532362070703A0163046D3F");
  }

  private void generateQrisToString(String payloadString) {
    QrisParser qrisParser = new QrisParser();
    QrisPayload qrisPayload = qrisParser.parse(payloadString);
    Qris qris = qrisMapper.map(qrisPayload.getQrisRoot());
    assertEquals(payloadString,qris.toString());
  }
  
  

}
