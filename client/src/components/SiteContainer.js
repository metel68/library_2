import React, {Component} from "react";
import {isAdmin, isManager} from "../utils";
import styled from "styled-components";
import {Link} from "react-router-dom";
import {Container, Divider} from "semantic-ui-react";

export default class SiteContainer extends Component {
  logout = () => {
    localStorage.setItem('isAuthorized', false);
    localStorage.setItem('role', 'GUEST');
  };

  render() {


    return (
      <Layout>
        <nav>
        <Wrapper>
          <Link to={{ pathname: '/' }}><h1>АБИС "Купш и К"</h1></Link>
        </Wrapper>
        <Wrapper>
          <Link to={{ pathname: '/user/current' }}>Просмотр профиля</Link>
          {isAdmin() ? <Link to={{ pathname: '/users/list' }}>Управление пользователями</Link> : null}
          {isManager() ? <Link to={{ pathname: '/book/create' }}>Добавить книгу</Link> : null}
          <a href="#" onClick={this.logout}>
            Выйти
          </a>
        </Wrapper>
        </nav>
        <Divider />
        {this.props.children}
      </Layout>
    );
  }
};

const Layout = styled(Container)`
  margin-top: 50px;
`;

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
  margin-top: 20px;
`;
