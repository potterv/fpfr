

import React from 'react';
import UserService from '../../../../../fpfr/react/fpfr/src/services/UserService';

class EmployeerComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            employeers:[]


        }

    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({ employeers: response.data})
        });
    }

    render (){
        return (
            <div>
                <h1 className = "text-center"> СПИСОК РАБОТОДАТЕЛЕЙ</h1>
                <form method="post" action="">
                <div className="container-fluid">
                <table className = "table table-striped table-bordered table-hover">
                    <thead class="thead-light">

                    <tr>
                        <th rowSpan="2">№ п/п</th>
                        <th colSpan="2">Работодатель</th>
                        <th colSpan="3">Сведения</th>
                        <th rowSpan="2">количество<br />застрахованных<br />лиц</th>
                        <th colSpan="4">Уведомление</th>
                        <th rowSpan="2">фактическая<br />дата<br />представления<br />сведений</th>
                        <th rowSpan="2">дата<br />акта</th>
                        <th rowSpan="2">примечания</th>
                        <th rowSpan="2">Количество ЗЛ, по которым выявлено правонарушения</th>
                        <th colSpan="2">Решение</th>
                        <th colSpan="2">Админ. Ответ</th>

                        <th rowSpan="2">протокол</th>

                        <th rowSpan="2"></th>
                    </tr>
                    <tr>
                        <th>Рег. №</th>
                        <th>Название</th>
                        <th>вид</th>
                        <th>месяц</th>
                        <th>год</th>
                        <th>дата</th>
                        <th>дата передачи</th>
                        <th>дата получения</th>
                        <th>контрольная дата</th>
                        <th>Привлечен/Не привлечен</th>
                        <th>Дата</th>
                        <th>Дата Протокола</th>
                        <th>Дата Определения</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.employeers.map(
                            employeer =>
                                <tr key = {employeer.id}>
                                    <td> {employeer.id}</td>
                                    <td> {employeer.regNum}</td>
                                    <td> {employeer.name}</td>


                                    <td>{employeer.empIntelligence.map(
                                        empin =>
                                            <tr key={empin.id}>
                                                <td>
                                                    {empin.type}
                                                </td>
                                            </tr>
                                    )}
                                    </td>
                                    <td>{employeer.empIntelligence.map(
                                        empin =>
                                            <tr key={empin.id}>
                                                <td>
                                                    {empin.month}
                                                </td>
                                            </tr>
                                    )}
                                    </td>
                                    <td>{employeer.empIntelligence.map(
                                        empin =>
                                            <tr key={empin.id}>
                                                <td>
                                                    {empin.i_year}
                                                </td>
                                            </tr>
                                    )}</td>
                                    <td>{employeer.empIntelligence.map(
                                        empin =>
                                            <tr key={empin.id}>
                                                <td>
                                                    {empin.kolzl}
                                                </td>
                                            </tr>
                                    )}</td>


                                    <td>{employeer.empNotices.dateNotices}</td>
                                    <td>{employeer.empNotices.dateNoticesTransfer}</td>
                                    <td>{employeer.empNotices.dateNoticesIn}</td>
                                    <td>{employeer.empNotices.controlDate}</td>

                                    <td><input type="text" id="fact_act_date" name="fact_act_date" value={employeer.empApendix.dateFact+" "+employeer.empApendix.id}/></td>
                                    <td><input type="text" id="act_date" name="act_date" value={employeer.empApendix.dateAct}/></td>
                                    <td><textarea name="comments" rows="1" cols="25">{employeer.empApendix.primechanie}</textarea> </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><input type="text" maxLength="4" size="2" id="protocol" name="protocol" value={employeer.empApendix.protockol}/></td>

                                    {/*<td><input type="submit" className="btn btn-info" name="save" value="СОХРАНИТЬ"/></td>*/}
                                    <td> <button className="btn btn-info" name="save" onClick = {this.render}> СОХРАНИТЬ </button> </td>
                                </tr>
                        )


                    }

                    </tbody>

                </table>
                </div>
                </form>
            </div>

        )
    }
}

export default EmployeerComponent

