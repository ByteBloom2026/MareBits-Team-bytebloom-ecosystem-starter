package model0
import domain.model.Mentee
import java.io.File
interface menteeDataProvider {//الحين هين احنا انشانا انترفيس بحيث انو اجلب البيانات اللي بدي اياها ولو صارتغير في هادي الداتا اقدر اعدل بسهولة
    fun fatchMentees(file : File): List<Mentee>//هين رحت انشا الدالة الي بدي اعمل الها اعادةكتابة بحيث  انو  لةو صر تغير لقدام ما ياثر على الكود لاني انا فاصلة الاشي اللي بتغير هي  البيانات عن اشي الثاب اللي هي البارسنق
}