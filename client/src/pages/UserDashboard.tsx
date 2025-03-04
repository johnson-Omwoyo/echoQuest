import { useState } from "react";
import "./userDashboard.css";
import AddSessionModal from "./NewSession";

function UserDashboard() {
  const [modalShow, setModalShow] = useState(false);
  const [sessions, setSessions] = useState([]);

  const handleShow = () => setModalShow(true);
  const handleClose = () => setModalShow(false);

  const handleSave = (newSession) => {
    // setSessions((prevSessions) => [...prevSessions, newSession]);
  };
  return (
    <div className="container">
      <AddSessionModal
        show={modalShow}
        handleClose={handleClose}
        handleSave={handleSave}
      />
      <div className="row d-flex gap-5 justify-content-around user-det">
        <div className="col  bg-white rounded py-3">
          <div className="m-4 p-3 rounded inner-cont1 ">
            <div className="d-flex flex-column my-3">
              <span className="name-title fs-3">Name</span>
              <span className="name">Johnson Omwoyo</span>
            </div>
            <div className="d-flex flex-column my-3">
              <span className="name-title fs-3">Role</span>
              <span className="name">Iterviewer & Interviewee</span>
            </div>
            <div className="d-flex flex-column my-3">
              <span className="name-title fs-3">OverAll Perfomance</span>
              <div className="d-flex align-items-center justify-content-center my-3">
                <div className="circle rounded-circle p-3">
                  <span className="fs-1 percentage name-title">100%</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="col bg-white rounded py-3 prev-cont">
          {" "}
          <div className="m-4 p-3 rounded inner-cont2 ">
            <span className="fs-3 name-title ">Previous Sessions</span>
            <div className=" rounded">
              <>
                {" "}
                <div className="d-flex my-3 justify-content-between">
                  <div className="d-flex flex-column ">
                    <span className="name-title">Category</span>
                    <span className="name">Technical</span>
                  </div>

                  <div className="d-flex flex-column">
                    <span className="name-title">Kevin klayne</span>
                    <span className="name">1h 23min</span>
                  </div>
                </div>
                <hr />
              </>
              <>
                {" "}
                <div className="d-flex my-3 justify-content-between">
                  <div className="d-flex flex-column ">
                    <span className="name-title">Category</span>
                    <span className="name">Technical</span>
                  </div>

                  <div className="d-flex flex-column">
                    <span className="name-title">Kevin klayne</span>
                    <span className="name">1h 23min</span>
                  </div>
                </div>
                <hr />
              </>
              <>
                {" "}
                <div className="d-flex my-3 justify-content-between">
                  <div className="d-flex flex-column ">
                    <span className="name-title">Category</span>
                    <span className="name">Technical</span>
                  </div>

                  <div className="d-flex flex-column">
                    <span className="name-title">Kevin klayne</span>
                    <span className="name">1h 23min</span>
                  </div>
                </div>
                <hr />
              </>
              <>
                {" "}
                <div className="d-flex my-3 justify-content-between">
                  <div className="d-flex flex-column ">
                    <span className="name-title">Category</span>
                    <span className="name">Technical</span>
                  </div>

                  <div className="d-flex flex-column">
                    <span className="name-title">Kevin klayne</span>
                    <span className="name">1h 23min</span>
                  </div>
                </div>
                <hr />
              </>
              <>
                {" "}
                <div className="d-flex my-3 justify-content-between">
                  <div className="d-flex flex-column ">
                    <span className="name-title">Category</span>
                    <span className="name">Technical</span>
                  </div>

                  <div className="d-flex flex-column">
                    <span className="name-title">Kevin klayne</span>
                    <span className="name">1h 23min</span>
                  </div>
                </div>
                <hr />
              </>
              <>
                {" "}
                <div className="d-flex my-3 justify-content-between">
                  <div className="d-flex flex-column ">
                    <span className="name-title">Category</span>
                    <span className="name">Technical</span>
                  </div>

                  <div className="d-flex flex-column">
                    <span className="name-title">Kevin klayne</span>
                    <span className="name">1h 23min</span>
                  </div>
                </div>
                <hr />
              </>
              <>
                {" "}
                <div className="d-flex my-3 justify-content-between">
                  <div className="d-flex flex-column ">
                    <span className="name-title">Category</span>
                    <span className="name">Technical</span>
                  </div>

                  <div className="d-flex flex-column">
                    <span className="name-title">Kevin klayne</span>
                    <span className="name">1h 23min</span>
                  </div>
                </div>
                <hr />
              </>
              <>
                {" "}
                <div className="d-flex my-3 justify-content-between">
                  <div className="d-flex flex-column ">
                    <span className="name-title">Category</span>
                    <span className="name">Technical</span>
                  </div>

                  <div className="d-flex flex-column">
                    <span className="name-title">Kevin klayne</span>
                    <span className="name">1h 23min</span>
                  </div>
                </div>
                <hr />
              </>
            </div>
          </div>
        </div>
        <div className="col d-flex flex-column rounded rate-calendar justify-content-between">
          <div className="bg-white rate rounded">top</div>{" "}
        </div>
      </div>
      <div className="row">
        <div className="col upcomings rounded my-5">
          <div className="d-flex justify-content-between mx-3 py-4  align-items-center">
            <div className="manage-head">
              <span className="fs-2 name-title">Sessions Management</span>
              <p className="p-0 m-0">
                Manage all the existing Sessions and schedule new ones
              </p>
            </div>
            <div>
              {" "}
              <button className="btn btn-primary py-3 " onClick={handleShow}>
                <i className="fa-solid fa-plus"> </i> Add New Session
              </button>
            </div>
          </div>
          <div>
            <table className="table table-striped table-bordered table-hover">
              <thead className="thead-dark">
                <tr>
                  <th scope="col">SE No</th>
                  <th scope="col">Interview Category</th>
                  <th scope="col">Period</th>
                  <th scope="col">Time Left</th>
                  <th scope="col">Actions</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>2</td>
                  <td>Behavioral</td>
                  <td>February 2025</td>
                  <td>5 mins</td>
                  <td className="d-flex justify-content-center">
                    <button className="btn btn-info">Join Session</button>
                  </td>
                </tr>
                <tr>
                  <td>1</td>
                  <td>Technical</td>
                  <td>January 2025</td>
                  <td>2 days 12 mins</td>
                  <td className=" d-flex align-items-center justify-content-center">
                    <button className="btn">...</button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserDashboard;
