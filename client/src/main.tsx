import "./init";
import ReactDOM from "react-dom/client";

import { RouterProvider, createBrowserRouter } from "react-router-dom";
import routes from "./Routes.tsx";

const route = createBrowserRouter(routes);

ReactDOM.createRoot(document.getElementById("root")!).render(
  <RouterProvider router={route} />
);
